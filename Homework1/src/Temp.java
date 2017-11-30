
import java.util.Arrays;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Temp {

	public Temp() {
	}

	private String task1array, task1substr, task2array, task2num, task2app, task3, task4, task5, result;

	

	public String getTask1array() {
		return task1array;
	}

	public void setTask1array(String task1) {
		this.task1array = task1;
	}

	public String getTask3() {
		return task3;
	}

	public void setTask3(String task3) {
		this.task3 = task3;
	}

	public String getTask4() {
		return task4;
	}

	public void setTask4(String task4) {
		this.task4 = task4;
	}

	public String getTask5() {
		return task5;
	}

	public void setTask5(String task5) {
		this.task5 = task5;
	}

	public String processingString() {

		setResult("result of first task is: " + Tasks.interviewStringTest(task1array, task1substr));
		return "success.xhtml";
	}

	public void processingArray() {
		// convert string array to int[]
		int[] arrayInt = Arrays.stream(task2array.split(" ")).mapToInt(Integer::parseInt).toArray();
		int number = Integer.parseInt(task2num);
		int appearance = Integer.parseInt(task2app);

		boolean resultValue = Tasks.interviewArrayTest(arrayInt, number, appearance);
		setResult("result of second task is: " + String.valueOf(resultValue));

	}

	public void makeRecurtion() {
		int r = Tasks.interviewRecursionTest(Integer.parseInt(task3));
		setResult("result of third task is: " + String.valueOf(r));

	}

	public void convertArrayToMap() {

		Map<String, Integer> result = Tasks.interviewMapTest(task4.split(" "));
		setResult("result of fourth task is: " + result.toString());

	}

	public void makeEncoding() {

		setResult("result of fifth task is: " + Application.toCustomEncoding(task5));

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTask2num() {
		return task2num;
	}

	public void setTask2num(String task2num) {
		this.task2num = task2num;
	}

	public String getTask2app() {
		return task2app;
	}

	public String getTask2array() {
		return task2array;
	}

	public void setTask2array(String task2) {
		this.task2array = task2;
	}

	public void setTask2app(String task2app) {
		this.task2app = task2app;
	}

	public String forward() {
		return "page2.xhtml";
	}

	public String getTask1substr() {
		return task1substr;
	}

	public void setTask1substr(String task1substr) {
		this.task1substr = task1substr;
	}

}
