package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Book;
import entity.Category;
import entity.Country;
import interfaces.EntityDBService;

/**
 * The DOMController is class that contains implementation of CRUD operations on
 * entity Book
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-11-21
 */

public class DOMController implements EntityDBService<Book> {

	private static String xmlFileName = "BookStore.xml";
	private static DocumentBuilderFactory dbf;
	private static DocumentBuilder db;
	private static Document doc;
	private static Element root;
	private static NodeList aNodeList;

	// initialization of source data
	static {
		dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println(e);
		}
		try {
			doc = db.parse(new File(xmlFileName));
		} catch (SAXException | IOException e) {
			System.out.println(e);
		}
		root = doc.getDocumentElement();
		aNodeList = root.getElementsByTagName("Book");
	}
	protected static List<Book> store = new ArrayList<Book>();

	public static void main(String argv[]) {

		DOMController domController = new DOMController();

		// get all XML elements
		System.out.println("Source XML:");
		NodeList aNodeList = root.getElementsByTagName("Book");
		List<Book> books;
		try {
			books = domController.getAllBooks(aNodeList);
			for (int i = 0; i < aNodeList.getLength(); i++) {
				System.out.println(books.get(i));
			}
		} catch (XPathExpressionException e) {
			System.out.println(e);
		}

		System.out.println("-------------------------------------");
		// add a new book
		List<String> category = new ArrayList<String>();
		category.add(Category.NOVEL.toString());
		category.add(Category.AUTHOBIOGRAPHY.toString());

		List<String> author = new ArrayList<String>();
		author.add("Ilf");
		author.add("Petrov");

		Book b1 = new Book("3", "12 chairs", category, Country.RUSSIA.toString(), "1910", author, "888888");
		domController.save(b1);

		System.out.println("Check add:");
		System.out.println(domController.load(3));
		System.out.println("-------------------------------------");

		// delete book
		domController.delete(1);
		System.out.println("Check delete:");
		System.out.println(domController.load(1));
		System.out.println("-------------------------------------");

		// update book
		List<String> category2 = new ArrayList<String>();
		category2.add(Category.AUTHOBIOGRAPHY.toString());

		Book b2 = new Book("2", "Hard Days", category2, Country.ENGLAND.toString(), "1985", author, "11111111111");
		domController.update(b2);
		System.out.println("Check update:");
		System.out.println(domController.load(2));

		System.out.println("-------------------------------------");
	}

	

	@Override
	public Book load(long id) {
		Book book = null;
		for (int i = 0; i < aNodeList.getLength(); i++) {

			NamedNodeMap attributes = aNodeList.item(i).getAttributes();
			Node theAttribute = attributes.item(0);
			String bookId = theAttribute.getNodeValue();
			if (id == Integer.valueOf(bookId)) {
				book = getBook(i);
			}
		}
		return book;
	}

	private Book getBook(int i) {
		Book book = new Book();
		Element qElement;

		NamedNodeMap attributes = aNodeList.item(i).getAttributes();
		Node theAttribute = attributes.item(0);
		book.setId(theAttribute.getNodeValue());

		qElement = (Element) aNodeList.item(i);

		Node qN1 = qElement.getElementsByTagName("Name").item(0);
		book.setName(qN1.getTextContent());
		Node qN2 = qElement.getElementsByTagName("Country").item(0);
		book.setCountry(qN2.getTextContent());
		Node qN3 = qElement.getElementsByTagName("Year").item(0);
		book.setYear(qN3.getTextContent());
		Node qN4 = qElement.getElementsByTagName("ISBN").item(0);
		book.setISBN(qN4.getTextContent());

		NodeList aNodeList1 = qElement.getElementsByTagName("Category");
		for (int j = 0; j < aNodeList1.getLength(); j++) {
			book.setCategory(aNodeList1.item(j).getTextContent());
		}

		NodeList nodeList = qElement.getElementsByTagName("Author");
		for (int j = 0; j < nodeList.getLength(); j++) {
			book.setAuthor(nodeList.item(j).getTextContent());
		}
		return book;

	}

	/**
	 * Method select all Book elements from xml file
	 * 
	 * @param nodeList
	 *            Pass list for converting it to the List of Book objects.
	 *
	 * 
	 * @exception XPathExpressionException
	 *                Represents an error in an XPath expression
	 * 
	 * @return List<Book>
	 */
	public List<Book> getAllBooks(NodeList aNodeList) throws XPathExpressionException {
		Book book;
		for (int i = 0; i < aNodeList.getLength(); i++) {

			book = getBook(i);
			store.add(book);
		}
		return store;

	}

	@Override
	public void update(Book entity) {

		for (int i = 0; i < aNodeList.getLength(); i++) {
			NamedNodeMap attributes = aNodeList.item(i).getAttributes();
			Node attribute = attributes.item(0);
			String bookId = attribute.getNodeValue();

			if (entity.getId().compareTo(bookId) == 0) {
				root.getElementsByTagName("Name").item(i).setTextContent(entity.getName());

				Node cNode = root.getElementsByTagName("Categories").item(i);
				NodeList catList = cNode.getChildNodes();
				for (int j = catList.getLength() - 1; j > 0; j--) {
					Node e = catList.item(j);
					e.getParentNode().removeChild(e);
				}

				for (String category : entity.getListCategories()) {
					Element categoryElement = doc.createElement("Category");
					categoryElement.setTextContent(category.trim());
					cNode.appendChild(categoryElement);
				}

				root.getElementsByTagName("Country").item(i).setTextContent(entity.getCountry());
				root.getElementsByTagName("Year").item(i).setTextContent(entity.getYear());

				Node aNode = root.getElementsByTagName("Authors").item(i);
				NodeList authList = aNode.getChildNodes();
				for (int j = authList.getLength() - 1; j > 0; j--) {
					Node e = authList.item(j);
					e.getParentNode().removeChild(e);
				}

				for (String author : entity.getListAuthors()) {
					Element authorElement = doc.createElement("Author");
					authorElement.setTextContent(author.trim());
					aNode.appendChild(authorElement);
				}
				root.getElementsByTagName("ISBN").item(i).setTextContent(entity.getISBN());
				try {
					saveToXML(doc, xmlFileName);
					return;
				} catch (TransformerException e) {
					System.out.println(e);
				}
			}
		}
	}


	@Override
	public void delete(long id) {
		for (int i = 0; i < aNodeList.getLength(); i++) {

			NamedNodeMap attributes = aNodeList.item(i).getAttributes();
			Node theAttribute = attributes.item(0);
			String bookId = theAttribute.getNodeValue();
			if (id == Integer.valueOf(bookId)) {
				root.removeChild(aNodeList.item(i));
				return;
			}

		}
		System.out.println("Entity not found");

	}

	
	@Override
	public void save(Book book) {
		Book tmp = load(Long.valueOf(book.getId()));
		if (tmp == null) {

			Element qElement = doc.createElement("Book");

			qElement.setAttribute("id", book.getId());
			root.appendChild(qElement);

			Element qElement1 = doc.createElement("Name");
			qElement1.setTextContent(book.getName());
			qElement.appendChild(qElement1);

			Element qElement2 = doc.createElement("Categories");
			qElement.appendChild(qElement2);

			for (String category : book.getListCategories()) {
				Element categoryElement = doc.createElement("Category");
				categoryElement.setTextContent(category);
				qElement2.appendChild(categoryElement);
			}

			Element qElement3 = doc.createElement("Country");
			qElement3.setTextContent(book.getCountry());
			qElement.appendChild(qElement3);

			Element qElement4 = doc.createElement("Year");
			qElement4.setTextContent(book.getYear());
			qElement.appendChild(qElement4);

			Element qtElement4 = doc.createElement("Authors");
			qElement.appendChild(qtElement4);

			for (String author : book.getListAuthors()) {
				Element authorElement = doc.createElement("Author");
				authorElement.setTextContent(author);
				qtElement4.appendChild(authorElement);
			}

			Element qElement5 = doc.createElement("ISBN");
			qElement5.setTextContent(book.getISBN());
			qElement.appendChild(qElement5);

			try {
				saveToXML(doc, xmlFileName);
			} catch (TransformerException e) {
				System.out.println(e);
			}
		}
		else 
		{
			System.out.println("In bookstore exist book with the same id. Check input data.");
		}
	}

	
	private void saveToXML(Document document, String xmlFileName) throws TransformerException {

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");
		t.transform(new DOMSource(document), new StreamResult(new File(xmlFileName)));

	}

}
