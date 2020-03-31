// Assignment #: 8
//         Name: Aaron Kampmeier
//    StudentID: 1217750807
//      Lecture: T&Th 10:30
//  Description: Manages all club objects.

import java.io.Serializable;

public class ClubManagement implements Serializable {
	private Club[] clubList;
	private int numberOfClubs, maxSize;

	public ClubManagement(int maximumSize) {
		maxSize = maximumSize;
		numberOfClubs = 0;
		clubList = new Club[maximumSize];
	}

	//Checks if a club exists
	public int clubExists(String clubName, String university) {
		for (int i = 0; i < numberOfClubs; i++) {
			if (clubList[i].getClubName().equals(clubName) && clubList[i].getUniversity().equals(university)) {
				return i;
			}
		}

		return -1;
	}

	//Checks if a club with a certain president exists
	public int currentPresidentExists(String firstName, String lastName, String academicLevel) {
		for (int i = 0; i < numberOfClubs; i++) {
			if (clubList[i].getCurrentPresident().getFirstName().equals(firstName) && clubList[i].getCurrentPresident().getLastName().equals(lastName) && clubList[i].getCurrentPresident().getAcademicLevel().equals(academicLevel)) {
				return i;
			}
		}

		return -1;
	}

	//Adds a club with the specified information
	public boolean addClub(String clubName, int numberOfMembers, String university, String firstName, String lastName, String academicLevel) {
		if (numberOfClubs < maxSize && clubExists(clubName, university) == -1) {
			Club newClub = new Club();
			newClub.setClubName(clubName);
			newClub.setNumberOfMembers(numberOfMembers);
			newClub.setUniversity(university);
			newClub.setCurrentPresident(firstName, lastName, academicLevel);

			clubList[numberOfClubs] = newClub;
			numberOfClubs++;
			return true;
		} else {
			return false;
		}
	}

	//Removes a club with the specified information
	public boolean removeClub(String clubName, String university) {
		int index = clubExists(clubName,university);
		if (index < 0) return false;

		//Shift all club objects upstream of it in the array down, excluding the last place which shall just be set to null
		for (int i = index; i < clubList.length - 1; i++) {
			clubList[i] = clubList[i + 1];
		}
		clubList[maxSize - 1] = null;

		numberOfClubs--;

		return true;
	}

	//Sorts the clubs by name
	public void sortByClubNames() {
		Sorts.sort(clubList, numberOfClubs, new ClubNameComparator());
	}

	//Sorts the clubs by member numbers
	public void sortByMemberNumbers() {
		Sorts.sort(clubList, numberOfClubs, new MemberNumberComparator());
	}

	//Sorts the clubs by current president
	public void sortByCurrentPresidents() {
		Sorts.sort(clubList, numberOfClubs, new CurrentPresidentComparator());
	}

	//Returns a list of every club's description
	public String listClubs() {
		StringBuilder list = new StringBuilder("\n");

		if (numberOfClubs == 0) {
			list.append("no club\n");
		}

		for (int i = 0; i < numberOfClubs; i++) {
			list.append(clubList[i].toString());
		}

		list.append("\n");
		return list.toString();
	}

	//Closes club management: erases all clubs and resets the count to 0
	public void closeClubManagement() {
		for (int i = 0; i < clubList.length; i++) {
			clubList[i] = null;
		}
		numberOfClubs = 0;
	}

	//Serializable support
	public void copy(ClubManagement other) {
		this.clubList = other.clubList;
		this.numberOfClubs = other.numberOfClubs;
		this.maxSize = other.maxSize;
	}
}
