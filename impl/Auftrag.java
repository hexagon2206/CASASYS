import java.util.*;

public class Auftrag extends MObject {

	protected Collection<Auftrag> kinder;
	protected Collection<Ladung> umfasst;
	protected Auftrag vater;
	private int gewinn;
	private Trucker owner;
	private boolean done;

	/**
	 * 
	 * @param uID
	 * @param owner
	 * @param ladung
	 * @param gewinn
	 */
	public Auftrag(String uID, Trucker owner, Collection<Ladung> ladung, int gewinn) {
		super(uID);
		
		this.owner = owner;
		this.umfasst = ladung;
		this.kinder = new ArrayList<>();
		this.gewinn = gewinn;
		done  = false;
	}

	/**
	 * erzeugt eine Liste von Subaufträgen aus diesem Auftrag. sind die Listen ladungen und values nicht gleich lang
	 * wird null zurückgegeben.
	 * @param ladungen
	 * @param values
	 * @return List<Auftrag> mit allen Subaufträgen
	 */
	public Collection<Auftrag> split(Collection<Collection<Ladung>> ladungen, Collection<Integer> values) {
		if(!(ladungen.size() == values.size())) return null;
		Collection<Ladung> tmp = new ArrayList<>(umfasst);
		
		for(Collection<Ladung> l : ladungen) {
			int ts = tmp.size();
			tmp.removeAll(l);
			if(tmp.size() != ts-l.size()) return null;			
		}
		Collection<Auftrag> toret = new ArrayList<>();
		Iterator<Collection<Ladung>> ladungIt = ladungen.iterator();
		Iterator<Integer> valueIt = values.iterator();
		int i=0;
		while(ladungIt.hasNext()){
			toret.add(new Auftrag(this.getUID()+"_"+i++, this.owner, ladungIt.next(), valueIt.next()));
		}
		return toret;
	}

	public boolean isDone() {
		return this.done;
	}


	/**
	 * prueft, ob alle Bedingungen für den Abschluss eines Auftrags erfüllt sind. 
	 * Falls ja, wird der Besitzer ausgezahlt und der Vaterauftrag ebenfalls überprüft. 
	 */
	public boolean finalise() {
		if(this.isDone()) return false;
		if(this.owner.isAt.done != 1) return false;
		Iterator<Ladung> li = umfasst.iterator();
		while(li.hasNext()){
			Ladung l = li.next();
			if(!this.owner.ladung.contains(l)) continue;
			if(l.ziel == this.owner.isAt.at.ziel){
				this.owner.ladung.remove(l);
				li.remove();
			}
		}
		if(!umfasst.isEmpty()) return false;
		for(Auftrag a : this.kinder){
			if(a.isDone()==false) return false;
		}
		if(null!=this.vater){
			this.vater.owner.bookMoney(this.gewinn);
			this.owner.bookMoney(-this.gewinn);
		}
		this.done=true;
		vater.finalise();
		return true;
	}
}