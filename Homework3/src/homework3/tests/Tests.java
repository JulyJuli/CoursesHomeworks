package homework3.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import homework3.classes.Notebook;

public class Tests {

	Notebook nb = new Notebook();
	Notebook nb1 = new Notebook();

	// adding new contact

	@Test
	public void addContactTest() {
		nb.addContact("Yuliia", "0987654320");
		assertTrue(nb.checkForContains("Yuliia"));
	}

	@Test
	public void addPhoneToExistingContactTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Yuliia", "0987654321");
		assertTrue(nb.checkForContainsForContact("Yuliia", "0987654320"));
		assertTrue(nb.checkForContainsForContact("Yuliia", "0987654321"));
	}

	@Test
	public void addTheSameContactTest() {
		nb.addContact("Yuliia", "0987654320");

		assertTrue(nb.checkForContainsForContact("Yuliia", "0987654320"));
	}

	@Test
	public void addTheSameContactTest2() {
		nb.addContact("Yuliia", "0987654320");

		assertFalse(nb.checkForContains("Anna"));
	}

	@Test
	public void validatePhoneTest() {
		assertFalse(nb.validatePhone("098765432"));
	}

	@Test
	public void validatePhoneTest2() {
		assertTrue(nb.validatePhone("0987654320"));
	}

	@Test
	public void removeContanctTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654321");
		assertEquals("Contact Anna deleted successfuly!", nb.removeContact("Anna"));
	}

	@Test
	public void removeContanctTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654321");
		assertEquals("Contact Petr does not exist. Check your input", nb.removeContact("Petr"));
	}

	@Test
	public void sortTest() {
		StringBuilder sb = new StringBuilder();
		sb.append("Anna [0987654321]" + "\n");
		sb.append("Bogdan [0987654324]" + "\n");
		sb.append("Yuliia [0987654320]" + "\n");
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654321");
		nb.addContact("Bogdan", "0987654324");

		assertEquals(sb.toString(), nb.sort());
	}

	@Test
	public void sortTest2() {
		StringBuilder sb = new StringBuilder();
		sb.append("Contact list is empty");

		assertEquals(sb.toString(), nb.sort());
	}

	@Test
	public void editContactNameTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654321");

		String result = nb.editContactName("Anatiliy", "Anastasia");
		assertEquals("Contact does not exist. Check input data.", result);
	}

	@Test
	public void editContactNameTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654321");

		String result = nb.editContactName("Anna", "Anastasia");
		assertEquals("Full name was edited", result);
	}

	@Test
	public void editContactPhoneTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Yuliia", "0987654322");

		String result = nb.editContactPhone("Yuliia", "0987654320", "0987654329");
		assertEquals("Phone was edited", result);
	}

	@Test
	public void editContactPhoneTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Yuliia", "0987654322");

		String result = nb.editContactPhone("Yuliia", "09876543", "");
		assertEquals("Check input values", result);
	}

	@Test
	public void editContactPhoneTest3() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Yuliia", "0987654322");

		String result = nb.editContactPhone("Marta", "09876543", "12345678");
		assertEquals("Contact does not exist. Check input data.", result);
	}

	@Test
	public void getContactByFullNameTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");

		String result = nb.getContactByFullName("Anna");
		assertEquals("Full Name: Anna| Phone:0987654322", result);
	}

	@Test
	public void getContactByFullNameTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");

		String result = nb.getContactByFullName("Petr");
		assertEquals("This contact does not exist", result);
	}

	@Test
	public void getContactByPhoneTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");

		String result = nb.getContactByPhone("0987654322");
		assertEquals("Full Name: Anna| Phone:0987654322", result);
	}

	@Test
	public void getContactByPhoneTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");

		String result = nb.getContactByPhone("0987654323");
		assertEquals("Phone not exist in contact list", result);
	}

	@Test
	public void getContactByPartOfNameTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getContactByPartOfName("na");
		assertEquals("Full Name: Anna| Phone:0987654322" + "\n" + "Full Name: Kanna| Phone:0987654328", result);
	}

	@Test
	public void getContactByPartOfNameTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getContactByPartOfName("da");
		assertEquals("Contacts not found", result);
	}

	@Test
	public void getContactByPartOfNameTest3() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getContactByPartOfName("");
		assertEquals("Input is empty", result);
	}

	@Test
	public void getContactByPartOfPhoneTest() {
		nb.addContact("Yuliia", "0957654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getContactByPartOfPhone("098");
		assertEquals("Full Name: Anna| Phone: 0987654322" + "\n" + "Full Name: Kanna| Phone: 0987654328", result);
	}

	@Test
	public void getContactByPartOfPhoneTest2() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getContactByPartOfPhone("093");
		assertEquals("Contacts not found", result);
	}

	@Test
	public void getContactByPartOfPhoneTest3() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getContactByPartOfPhone("");
		assertEquals("Input is empty", result);
	}

	@Test
	public void getFirstAddedContactTest() {
		nb.addContact("Yuliia", "0987654320");
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");

		String result = nb.getFirstAddedContact();
		assertEquals("Full Name: Yuliia| Phone:0987654320", result);
	}

	@Test
	public void getFirstAddedContactTest2() {
		String result = nb.getFirstAddedContact();
		assertEquals("Contact list is empty", result);
	}

	@Test
	public void getLastAddedContactTest() {
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");
		nb.addContact("Yuliia", "0987654320");

		String result = nb.getLastAddedContact();
		assertEquals("Full Name: Yuliia| Phone:0987654320", result);
	}

	@Test
	public void getLastAddedContactTest2() {
		String result = nb.getLastAddedContact();
		assertEquals("Contact list is empty", result);
	}

	@Test
	public void searchByDateTest() {
		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");
		nb.addContact("Yuliia", "0987654320");
		String result = nb.searchByDate("01/10/2017", "30/10/2017");
		assertNotNull(result);
	}

	// does not work?
	// @Test(expected = ParseException.class)
	// public void searchByDateTest2() {
	// nb.addContact("Anna", "0987654322");
	// nb.addContact("Kanna", "0987654328");
	// String result = nb.searchByDate("01/10/2017", "30.10/2017");
	// assertEquals("Invalid input. Date format should be: dd/MM/yyyy", result);
	// }

	@Test
	public void searchByDateTest3() {
		String result = nb.searchByDate("01/12/2017", "30/10/2017");
		assertEquals("Check input.  First date bigger then second", result);
	}

	@Test
	public void equalsTest() {

		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");
		nb1.addContact("Anna", "0987654322");
		nb1.addContact("Kanna", "0987654328");
		assertTrue(nb.equals(nb1));
	}

	@Test
	public void equalsTest2() {

		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");
		assertTrue(nb.equals(nb));
	}

	@Test
	public void equalsTest3() {

		nb.addContact("Anna", "0987654322");
		nb1.addContact("Kanna", "0987654328");
		assertFalse(nb.equals(nb1));
	}

	@Test
	public void equalsTest4() {

		nb.addContact("Anna", "0987654322");
		List<String> test = new ArrayList<String>();
		assertFalse(nb.equals(test));
	}

	@Test
	public void hashCodeTest() {

		nb.addContact("Anna", "0987654322");
		nb.addContact("Kanna", "0987654328");
		nb1.addContact("Anna", "0987654322");
		nb1.addContact("Kanna", "0987654328");
		assertTrue(nb.hashCode() == nb1.hashCode());
	}

	@Test
	public void toStringTest() {

		nb.addContact("Anna", "0987654322");

		assertEquals("Full Name: Anna| Phone:0987654322", nb.toString());
	}

}
