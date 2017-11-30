package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * The SerializationOfObject class is intended on serialize and deserialize
 * Figure objects.
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-10-29
 */
public class SerializationOfObject {

	final static Logger logger = Logger.getLogger(SerializationOfObject.class);	
	

	

	/**
	 * Method serialize the List of Figure objects
	 * 
	 * @param figuresList
	 *            This is the first parameter writeObject method. Pass list for
	 *            serialization.
	 *
	 * @param nameOfZip
	 *            This is the second parameter to writeObject method. Pass name
	 *            for archive with serialized list
	 * 
	 * @exception IOException
	 *                Occur when method have some problems with i/o streams
	 * 
	 */
	public static void writeObject(List<Figure> figuresList, String nameOfZip) {
		

		if (figuresList.isEmpty()) {

			logger.error("Fail! " + "List is empty");

		} else {
			ZipOutputStream outZipFile = null;
			ZipEntry entryZip;
			ObjectOutputStream oos = null;

			try {
				outZipFile = new ZipOutputStream(new FileOutputStream(nameOfZip + ".zip"));
				entryZip = new ZipEntry("state.bin");
				outZipFile.putNextEntry(entryZip);

				oos = new ObjectOutputStream(outZipFile);
				oos.writeObject(figuresList);

				oos.flush();
				oos.close();

				outZipFile.flush();
				outZipFile.close();

				logger.info("Success sezialization");

			} catch (IOException e) {
				logger.error("Fail sezialization", e);
			}
		}

	}

	/**
	 * Method deserialize the List of Figure objects
	 * 
	 * @param zipFile
	 *            Pass directory with name of archive with serialized list
	 * 
	 * @exception IOException
	 *                Occur when method have some problems with i/o streams
	 *
	 * @exception FileNotFoundException
	 *                Occur when method can't find file on passed directory
	 */
	public static List<Figure> readObject(String zipFile) {

		ZipInputStream in;
		try {
			in = new ZipInputStream(new FileInputStream(zipFile));
			if ((in.getNextEntry()) != null) {
				List<Figure> result = unpack(in);
				logger.info("Success desezialization");
				return result;
			} else {
				logger.error("Object is Empty");
			}

			in.close();
		} catch (FileNotFoundException e) {
			logger.error("File " + zipFile + " not found. Please, check input.");
		} catch (IOException e) {
			logger.error("Something wrong..", e);
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	private static List<Figure> unpack(ZipInputStream in) {
		ObjectInputStream ois;
		List<Figure> listFigures;
		try {
			ois = new ObjectInputStream(in);

			listFigures = new ArrayList<Figure>();
			listFigures = (ArrayList<Figure>) ois.readObject();

			ois.close();

			return listFigures;

		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (IOException ioException) {
			logger.error(ioException);
		}
		return null;
	}

}
