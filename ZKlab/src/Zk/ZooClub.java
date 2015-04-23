package Zk;



import java.util.*;
import java.util.Map.Entry;
import java.util.Formatter;
public class ZooClub {

	List<Pet> list;
	Map<Person, List<Pet>> map;
	Set<Entry<Person, List<Pet>>> set;
	Iterator<Entry<Person, List<Pet>>> iter;
	static Formatter x ;

	ZooClub() {
		list = new ArrayList<>();
		map = new HashMap<>();
		set = map.entrySet();
		iter = set.iterator();
	
	}


	public static void showMenu() {
		System.out.println("\n1) ������ ������ �������� � ����."
				+ "\n2) ������ �������� �������� �����."
				+ "\n3) �������� �������� �������� �����."
				+ "\n4) �������� �������� ����� ."
				+ "\n5) �������� ���������� ��� ������ � ��� ��������."
				+ "\n6) ����������� ���� �������." 
				+ "\n7) ����� � ��������."
				+ "\n8) �������� ");
		
	}

	public void addPerson() {// dodatu vlasnuka

		System.out.println("������ ��� �������� �����: ");
		Scanner scaddPerson = new Scanner(System.in);
		String name = scaddPerson.nextLine();

		System.out.println("������ �� �������� �����: ");
		Scanner scaddPerson1 = new Scanner(System.in);
		int age = scaddPerson1.nextInt();

		map.put(new Person(name, age), new ArrayList<Pet>());
		// System.out.println(map);
		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();
		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			System.out.println(temp);
		}
	}

	public void addPet() {// dodatu tvarunky Map<Person, List<Pet>> map

		System.out.println("������ ��� ��������");
		Scanner scAddPet = new Scanner(System.in);
		String nameown = scAddPet.nextLine();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();

		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			if (temp.getKey().getName().equalsIgnoreCase(nameown)) {

				System.out.println("������ ��� �������� �� ������: ");
				Scanner sctype = new Scanner(System.in);
				String type = sctype.nextLine();

				System.out.println("������ ��� ��������: ");
				Scanner sc1 = new Scanner(System.in);
				String name = sc1.nextLine();

				temp.getValue().add(new Pet(type, name));
			}

			// System.out.println(map);

		}
		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp1 = iter.next();
			System.out.println(temp1);
		}

	}

	public void removePet() {// vudalutu
								// tvarunky Map<Person, List<Pet>> map
		System.out.println("������ ��� ��������");
		Scanner scRemovePet = new Scanner(System.in);
		String nameown = scRemovePet.nextLine();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();

		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			if (temp.getKey().getName().equals(nameown)) {

				System.out.println("������ ��� �������� �� ���������: ");
				Scanner scRemovePet1 = new Scanner(System.in);
				String type = scRemovePet1.nextLine();

				System.out.println("������ ��� ��������: ");
				Scanner scRemovePet2 = new Scanner(System.in);
				String name = scRemovePet2.nextLine();

				temp.getValue().remove(new Pet(type, name));

			}

		}
	}

	public void menu() {
		while (true) {
			ZooClub.showMenu();
			Scanner scMenu = new Scanner(System.in);
			int k = scMenu.nextInt();

			switch (k) {
			case (1): {
				addPerson();
				break;
			}
			case (2): {
				addPet();
				break;
			}
			case (3): {
				removePet();
				break;
			}
			case (4): {
				removePerson();
				break;
			}
			case (5): {
				removeAllPet();
				break;
			}
			case (6): {
				allclub();
				break;
			}
			case (7): {
				exit();
				break;
			}
			case (8):{
				seyv();
				break;
			}
			default:
				System.out.println("���� ������ ������ ");
				return;
			}

		}
	}

	public void removePerson() {

		System.out.println("������ ��� ��������");
		Scanner scRemovePerson = new Scanner(System.in);
		String nameown = scRemovePerson.nextLine();

		System.out.println("������ �� ��������:");
		Scanner scRemovePerson1 = new Scanner(System.in);
		int age = scRemovePerson1.nextInt();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter2 = setMap.iterator();

		while (iter2.hasNext()) {
			Entry<Person, List<Pet>> temp = iter2.next();

			if (temp.getKey().getName().equalsIgnoreCase(nameown)
					&& temp.getKey().getAge() == age) {
				map.remove(temp.getKey());

			}

		}
	}

	public void removeAllPet() {

		System.out.println("������ ��� ��������");
		Scanner scRemoveAllPet = new Scanner(System.in);
		String nametype = scRemoveAllPet.nextLine();

		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();

		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();

			Iterator<Pet> iterPet = temp.getValue().iterator();

			while (iterPet.hasNext()) {
				Pet petdel = iterPet.next();

				if (petdel.getAnimal().equals(nametype)) {
					iterPet.remove();

				}
			}
		}
	}

	public void allclub() {
		Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
		Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();
		while (iter.hasNext()) {
			Entry<Person, List<Pet>> temp = iter.next();
			System.out.println(temp);
		}
		if (map.isEmpty()) {
			System.out.println("\t��� ��� ���� �������� �����");
		}
	}

	public void exit() {
		System.exit(0);
		

	}

	public void seyv(){
		try{
			//Array Blocking Queue
			Set<Entry<Person, List<Pet>>> setMap = map.entrySet();
			Iterator<Entry<Person, List<Pet>>> iter = setMap.iterator();
			x = new Formatter ("filS\\Save.txt");
			while (iter.hasNext()) {
				Entry<Person, List<Pet>> temp = iter.next();
				x.format( ";lsdkfj %s", temp );
		
			}
			
			x.close();
			
			}catch(Exception e ) {};
		
		}
	
}
