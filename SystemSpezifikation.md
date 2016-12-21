#Ort
- hat localservices
- hat eine liste von Tupel für erreichbare Orte (Ort: Ziel, int: kosten) :: kosten == Zeitkosten?

#Position
- ist ein Ort oder ein Tripel (Ort:Herkunft, Ort:Ziel, %:Prozent)

#Localservice - Interface

#Boerse :: Localservice
- hat 0..n Aufträge

#Tanke :: Localservice
- hat Tankpreis

#Ladebucht :: Localservice
- hat 0..n Ladung

#Funk :: Localservice
- synchrone Kommunikation

#SchwarzesBrett :: Localservice
- asynchrone Kommunikation

#Ladung
- hat Startort
- hat Zielort
- wird von Umladebucht zu Umladebucht transportiert
- befindet sich immer in Agent oder in Ladebucht

#Auftrag
- hat Besitzer
- hat Ersteller
- kennt Parent-Auftrag
- kennt Sub-Auftraege
- befindet sich immer in Agent oder in Boerse
- hat 0..n Ladung
- wenn Unterauftrag vorhanden, hat keine Ladung (ist nur Checkliste zur Überwachung der Subauftraege und Auszahlung)

#Agent - Interface
-? hat speed
- hat position
- hat Kontostand
- hat Tankfuellstand

#LKW :: Agent
- hat ladung
- kann sich nur durch das Bezahlen von Auftraegen verschulden

#Auftragsgenerator :: Agent
- hat unendlichen kontostand
- hat unendlichen TankFuellstand
- generiert Auftraege und Ladung und stellt diese ein

#?Ereignisgenerator
- modifiziert Straßen (auch entfernen und hinzufügen?)
- Änderungen betreffen keine Fahrzeuge, die Bereits auf der Straße sind

######

Auftraege

				A (inh: Generator) Generator erzeugt Unterauftrag B aus A
						|
				B (inh: Hugo) - wird von Generator erzeugt und in Börse an Hugo verkauft - Hugo splittet diesen in C und D
				|																		|
C (inh. Karl) - wird von Hugo in Börse an Karl verkauft				D (inh. Hugo) Hugo behält ihn selbst

Bei Abschließen eines Auftrags wird der Besitzer des Vater-Auftrags benachrichtigt. Dieser zahlt dann aus und kann Subauftraege streichen.