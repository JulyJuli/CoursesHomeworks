package homework3.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Notebook class is intended on operation with inner class Contact. It
 * stores Map of Contact values .
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-10-23
 */
public class Notebook {

	// for testing: it helps generate different dates of add
	public static long count = 0;

	private String fullName;
	private String nPhone;

	// check for exist phone in contact list
	private List<String> nPhones = new ArrayList<String>();

	Map<String, Contact> contacts = new LinkedHashMap<String, Contact>();

	/**
	 * This method is used to add a new contact in Map. It contains different
	 * checkers for valid input value, such as check for existing contact and
	 * check for valid phone.
	 * 
	 * @param fullName
	 *            This is the first paramter to addContact method
	 * @param nPhone
	 *            This is the second parameter to addContact method
	 */

	public void addContact(String fullName, String nPhone) {

		this.fullName = fullName;
		this.nPhone = nPhone;

		if (!validatePhone(nPhone) || checkForContainsForContact(fullName, nPhone)) {
			return;
		}

		else {
			nPhones.add(nPhone);
			contacts.put(fullName, new Contact(fullName));
			contacts.get(fullName).setNumberPhones(nPhone);
		}
	}

	
	/**
	 * This method is used to validate a phone number via regex.
	 * 
	 * @param nPhone
	 *            inputted phone number
	 * 
	 * @return boolean if phone is valid, return true
	 */
	
	public boolean validatePhone(String nPhone) {

		// https://stackoverflow.com/questions/42104546/java-regular-expressions-to-validate-phone-numbers

		Pattern p = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
		Matcher m = p.matcher(nPhone);

		if (m.find()) {

			return true;
		}
		System.out.println("Invalid number phone. Sequence should be 10 numbers");
		return false;

	}

	
	/**
	 * This method is used for checking contain certain contact.
	 * 
	 * @param fullName
	 *            Value for check
	 * 
	 * 
	 * @return boolean It Map contain contact, method return true
	 */
	
	public boolean checkForContains(String fullName) {
		if (contacts.containsKey(fullName)) {
			return true;
		} else
			return false;
	}

	
	/**
	 * This method is used to check inputed data for a dublication. For the
	 * instance of Notebook, there must be unique values for the fullName and
	 * nPhone
	 * 
	 * @param fullName
	 *            First parameter of checkForContainsForContact method. Pass
	 *            user's full name
	 * @param nPhone
	 *            Second parameter of checkForContainsForContact method. Pass
	 *            user's phone number
	 *
	 * @return boolean If instance contains inputted fullName or phone number -
	 *         method return true
	 */
	
	public boolean checkForContainsForContact(String fullName, String nPhone) {

		if (contacts.containsKey(fullName)) {

			if (nPhones.contains(nPhone)) {
				System.out.println("This number already exist in current contact. Please, check input data.");
				return true;
			}

			addPhoneForExistingContact(fullName, nPhone);
			return true;
		}

		return false;

	}

	
	/**
	 * Method is used for adding phone number to existing contact of Notebook's
	 * instance
	 * 
	 * @param fullName
	 *            First parameter of addPhoneForExistingContact. Pass user's
	 *            full name
	 * @param nPhone
	 *            Second parameter of addPhoneForExistingContact method. Pass
	 *            user's phone number
	 *
	 */
	
	public void addPhoneForExistingContact(String fullName, String nPhone) {

		contacts.get(fullName).setNumberPhones(nPhone);

	}

	
	/**
	 * Method is used for remove contact from Notebook's instance. If contact
	 * does not exist, method print message with warning.
	 * 
	 * @param fullName
	 *            Pass user's full name for search contact in Map
	 *
	 * @return String result of removing
	 */

	public String removeContact(String fullName) {
		if (contacts.containsKey(fullName)) {
			contacts.remove(fullName);
			return "Contact " + fullName + " deleted successfuly!";
		}

		return "Contact " + fullName + " does not exist. Check your input";
	}

	
	/**
	 * Method is used for sort contacts from Notebook's instance alphabetically.
	 * If contact is empty, method print message with warning.
	 * 
	 * @return String Method return sorted LinkedHashMap
	 * 
	 */

	public String sort() {
		if (!contacts.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			Map<String, Contact> treeMap = new TreeMap<String, Contact>(contacts);

			for (Map.Entry<String, Contact> entry : treeMap.entrySet()) {
				sb.append(entry.getValue().fullName + " ");
				sb.append(entry.getValue().nPhones + "\n");
			}
			return sb.toString();
		}
		return "Contact list is empty";
	}

	
	/**
	 * Method is used for edit fullName of existing contact. If contact not
	 * found, method print message with warning.
	 * 
	 * 
	 * @param oldFullName
	 *            First parameter of editContactName method. Passing user's old
	 *            full name
	 * 
	 * @param newFullName
	 *            Second parameter of editContactName method. Passing a new full
	 *            name
	 * 
	 * @return String Method return result of editing: success or not
	 * 
	 */
	
	public String editContactName(String oldFullName, String newFullName) {

		if (contacts.containsKey(oldFullName)) {
			contacts.put(newFullName, contacts.get(oldFullName));
			contacts.get(newFullName).setFullName(newFullName);

			contacts.remove(oldFullName);

			return "Full name was edited";
		} else
			return "Contact does not exist. Check input data.";
	}

	
	/**
	 * Method is used for edit phone number of existing contact. If contact not
	 * found, method print message with warning.
	 * 
	 * 
	 * @param fullName
	 *            First parameter of editContactPhone method. Passing user's
	 *            full name
	 * 
	 * @param oldPhone
	 *            Second parameter of editContactName method. Passing a phone
	 *            number, that user want to edit
	 *
	 * @param newPhone
	 *            Third parameter of editContactName method. Passing a new phone
	 *            number
	 *
	 * @return String Method return result of editing: success or not
	 * 
	 *
	 */

	public String editContactPhone(String fullName, String oldPhone, String newPhone) {
		if (fullName.isEmpty() || oldPhone.isEmpty() || newPhone.isEmpty()) {
			return "Check input values";
		}
		if (contacts.containsKey(fullName)) {
			contacts.get(fullName).editPhoneN(oldPhone, newPhone);
			return "Phone was edited";
		} else
			return "Contact does not exist. Check input data.";
	}

	
	/**
	 * Method is used for searching contact via full name. If contact not found,
	 * method print message with warning.
	 * 
	 * 
	 * @param fullName
	 *            Parameter of getContactByFullName method, it passing full name
	 *            for searching
	 * 
	 *
	 * @return String Contact that was found
	 *
	 */
	
	public String getContactByFullName(String fullName) {
		String result;
		if (contacts.containsKey(fullName)) {
			result = contacts.get(fullName).toString();
		} else
			result = "This contact does not exist";
		return result;
	}

	
	/**
	 * Method is used for searching contact via phone number. If contact not
	 * found, method print message with warning.
	 * 
	 * 
	 * @param nPhone
	 *            Parameter of getContactByPhone method, it passing phone number
	 *            for searching
	 * 
	 *
	 * @return String Contact that was found
	 *
	 */

	public String getContactByPhone(String nPhone) {
		for (Entry<String, Contact> entry : contacts.entrySet()) {
			if (entry.getValue().getNPhones().contains(nPhone)) {
				String key = entry.getKey();
				return contacts.get(key).toString();
			}

		}
		return "Phone not exist in contact list";

	}

	
	/**
	 * Method is used for searching contact via part of full name. If input is
	 * empty or contact not found, method print message with warning.
	 * 
	 * 
	 * @param name
	 *            Parameter of getContactByPartOfName method, it passing part of
	 *            full name for searching
	 * 
	 *
	 * @return String Contacts that was found
	 *
	 */
	
	public String getContactByPartOfName(String name) {

		if (name.isEmpty())
			return "Input is empty";

		StringBuilder sb = new StringBuilder("");

		Pattern p = Pattern.compile(name.toLowerCase());
		Matcher m;

		for (Entry<String, Contact> entry : contacts.entrySet()) {

			m = p.matcher(entry.getKey().toLowerCase());
			if (m.find()) {
				sb.append(entry.getValue() + "\n");
			}
		}
		return sb.toString().isEmpty() ? "Contacts not found" : sb.toString().trim();

	}

	
	/**
	 * Method is used for searching contact via part of phone number. If input
	 * is empty or contact not found, method print message with warning.
	 * 
	 * 
	 * @param nPhine
	 *            Parameter of getContactByPartOfPhone method, it passing part
	 *            of phone number for searching
	 * 
	 *
	 * @return String Contacts that was found
	 *
	 */
	
	public String getContactByPartOfPhone(String nPhone) {

		if (nPhone.isEmpty())
			return "Input is empty";

		StringBuilder sb = new StringBuilder("");

		Pattern p = Pattern.compile("^" + nPhone);
		Matcher m;

		for (Entry<String, Contact> entry : contacts.entrySet()) {

			List<String> listOfPhones = entry.getValue().getNPhones();
			for (String s : listOfPhones) {
				m = p.matcher(s);
				if (m.find()) {
					sb.append("Full Name: " + entry.getValue().getFullName() + "| ");
					sb.append("Phone: " + s + "\n");

				}
			}
		}
		return sb.toString().isEmpty() ? "Contacts not found" : sb.toString().trim();

	}

	
	/**
	 * Method is used for getting first added contact. If Map is empty, method
	 * print message with warning.
	 * 
	 *
	 * @return String First added contact
	 *
	 */

	public String getFirstAddedContact() {

		if (contacts.isEmpty())
			return "Contact list is empty";
		else

			return contacts.get(contacts.keySet().toArray()[0]).toString();
	}

	
	/**
	 * Method is used for getting last added contact. If Map is empty, method
	 * print message with warning.
	 * 
	 *
	 * @return String Last added contact
	 *
	 */
	
	public String getLastAddedContact() {

		if (contacts.isEmpty())
			return "Contact list is empty";
		else {
			int size = contacts.size();
			return contacts.get(contacts.keySet().toArray()[size - 1]).toString();
		}
	}

	
	/**
	 * Method is used for searching all added contacts between two dates.
	 * 
	 * 
	 * @exception ParseException
	 *                Occur when inputted data is invalid
	 * 
	 * @param fromDate
	 *            First parameter of searchByDate method. Lower data boundary
	 *
	 * @param toDate
	 *            Second parameter of searchByDate method. Upper data boundary
	 *
	 *
	 * @return String Contacts that was found
	 *
	 */
	
	public String searchByDate(String fromDate, String toDate) {

		StringBuilder sb = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Date from;
		try {
			from = formatter.parse(fromDate);

			Date to = formatter.parse(toDate);

			if (to.compareTo(from) < 0) {
				return "Check input.  First date bigger then second";
			}
			for (Entry<String, Contact> entry : contacts.entrySet()) {

				Date dateOfAdd = formatter.parse(entry.getValue().getDateOfAdd());

				if (dateOfAdd.after(from) && dateOfAdd.before(to) || dateOfAdd.compareTo(from) == 0
						|| dateOfAdd.compareTo(to) == 0) {
					sb.append(entry);
				}

			}
			return sb.toString();
		}

		catch (ParseException e) {
			return "Invalid input. Date format should be: dd/MM/yyyy";
		}

	}

	
	/**
	 * The Contact class is intended for store contact information.
	 *
	 * @author Yuliia Nechyporuk
	 * @version 1.0
	 * @since 2017-10-23
	 */
	public class Contact {

		private String fullName;
		private List<String> nPhones = new ArrayList<String>();

		private String dateOfAdd;

		Contact(String fullName) {
			setFullName(fullName);

			// commented line below is a code for real program
			// this.setDateOfAdd(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));

			// code for testing method "searchByDate"
			this.setDateOfAdd(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now().plusWeeks(count))); 
			count++;
		}

		/**
		 * Method is used for sorting list of phone numbers.
		 * 
		 *
		 */
		public void sortPhoneNumbers() {
			java.util.Collections.sort(nPhones);
		}

		/**
		 * Method is used for edit phone number of existing contact.
		 * 
		 * @param oldPhone
		 *            Second parameter of editPhoneN method. Passing a phone
		 *            number, that user want to edit
		 *
		 * @param newPhone
		 *            Third parameter of editPhoneN method. Passing a new phone
		 *            number
		 *
		 */

		public void editPhoneN(String oldPhone, String newPhone) {

			if (nPhones.contains(oldPhone)) {
				nPhones.remove(oldPhone);
				nPhones.add(newPhone);
			}

		}

		/**
		 * Method is used for remove phone number from contact. If phone does
		 * not exist, method print message with warning.
		 * 
		 * @param nPhone
		 *            Parameter for removing from List of phone numbers
		 *
		 * 
		 */

		public void removePhoneN(String nPhone) {
			if (nPhones.contains(nPhone)) {
				nPhones.remove(nPhone);
				return;
			}
			System.out.println("Phone does not exist");

		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getDateOfAdd() {
			return dateOfAdd;
		}

		public void setDateOfAdd(String dateOfAdd) {
			this.dateOfAdd = dateOfAdd;
		}

		public List<String> getNPhones() {
			return nPhones;
		}

		public void setNumberPhones(String nP) {

			nPhones.add(nP);

		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (String s : nPhones) {
				// sb.append("Full Name: " + fullName + "| Date of add phone: "
				// + dateOfAdd + "| Phone:" + s + '\n');
				sb.append("Full Name: " + fullName + "| Phone:" + s + '\n');
			}

			return sb.toString().trim();
		}

	}

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Notebook)) {
			return false;
		}

		Notebook contact = (Notebook) o;

		return contact.fullName == fullName && contact.nPhone == nPhone;
	}

	// Idea from effective Java : Item 9
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + fullName.hashCode();
		result = 31 * result + nPhone.hashCode();
		return result;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Entry<String, Contact> entry : contacts.entrySet()) {

			sb.append(entry.getValue());
		}
		return sb.toString();
	}

}
