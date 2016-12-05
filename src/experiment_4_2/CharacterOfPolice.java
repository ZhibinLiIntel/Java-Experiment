package experiment_4_2;

interface CharacterOfPolice{
	void Mood();
	void Behavior();
}
class GoodMoodPolice implements CharacterOfPolice{
	public void Mood(){
		System.out.println("Good mood");
	}
	public void Behavior(){
		System.out.println("Just let go");
	}
}
class BadMoodPolice implements CharacterOfPolice{
	public void Mood(){
		System.out.println("Bad mood");
	}
	public void Behavior(){
		System.out.println("Fine the driver");
	}
}
class TantanTraffic implements CharacterOfPolice{
	public void Mood(){
		System.out.println("Tantan");
	}
	public void Behavior(){
		System.out.println("Have an interview");
	}
}