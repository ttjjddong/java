package atguigu;

import java.util.Scanner;

/**
 * 设计一个：学生管理系统
 * 1.添加学生信息\n 2.显示学生信息\n 3.删除学生信息\n 4.修改学生信息\n5.查看学生信息\n 6.排序\n7.退出
 * 
 */

public class Manage {
	// 主模块；
	public static void main(String[] args) {
		Integer[] studentId = new Integer[100];
		Integer[] studentScore = new Integer[100];
		String[] studentName = new String[100];
		int number = 0;
		Integer studentCount = 0;
		int time = 0;
		System.out.println("欢迎进入学生管理系统\n1.添加学生信息\n2.显示学生信息\n" +
				"3.删除学生信息\n4.修改学生信息\n5.查询学生信息\n6.排序\n7.退出");
		while (true) {
			System.out.println("请输入选择：");
			Scanner scanner = new Scanner(System.in);
			number = scanner.nextInt();
			switch (number) {
			case 1:
				studentCount = add(studentId, studentName, studentScore,studentCount);
				System.out.println("添加成功");
				break;
			case 2:
				display(studentId, studentName, studentScore, studentCount);
				break;
			case 3:
				studentCount = delete(studentId, studentName, studentScore,
						studentCount);
				break;
			case 4:
				update(studentId, studentName, studentScore, studentCount);
				break;
			case 5:
				select(studentId, studentName, studentScore, studentCount);
				break;
			case 6:
				Sort(studentId, studentName, studentScore, studentCount);
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("请输入1-7之间的整数");
			}
		}
	}

	// 1.添加学生信息块
	public static Integer add(Integer[] studentId, String[] studentName,
			Integer[] studentScore, int studentCount) {
		System.out.println("请输入学生学号");
		Scanner s1 = new Scanner(System.in);
		studentId[studentCount] = s1.nextInt();
		System.out.println("请输入学生姓名");
		Scanner s2 = new Scanner(System.in);
		studentName[studentCount] = s2.next();
		System.out.println("请输入学生成绩");
		Scanner s3 = new Scanner(System.in);
		studentScore[studentCount] = s3.nextInt();
		studentCount++;
		return studentCount;
	}

	// 2.显示学生信息块
	public static void display(Integer[] studentId, String[] studentName,
			Integer[] studentScore, int studentCount) {
		String str = "学号"+"\t姓名"+"\t成绩\n";
		for(int i = 0; i < studentCount; i++){
			str = studentId[i] + "\t" + studentName[i] + "\t"
					+ studentScore[i] + "\n";
		}
	}
	
	// 3.删除学生信息
		public static int delete(Integer[] studentId, String[] studentName,
				Integer[] studentScore, int studentCount) {
			Integer temp = select(studentId,studentName,studentScore,studentCount);
			System.out.println("是否确定要删除此条信息。是：选1；否：选0");
			Scanner s = new Scanner(System.in);
			int j = s.nextInt();
			switch(j){
			case 0:
				System.out.println("你已取消了删除操作");
				break;
			case 1:
				for(int i=0;i<studentCount;i++){
					if(studentName.equals(studentName[i])){
						if(i<studentCount-1){
							studentId[i] = studentId[i+1];
							studentName[i] = studentName[i+1];
							studentScore[i] = studentScore[i+1];
						}
						studentId[i] = null;
						studentName[i] = null;
						studentScore[i] = null;
						return studentCount--;
					}
						
				}
			}
			return studentCount;
		}
		
		// 4.修改学生信息块
		public static void update(Integer[] studentId, String[] studentName,
				Integer[] studentScore, int studentCount) {
			Integer temp = select(studentId, studentName, studentScore, studentCount);
			if(temp == null){
				System.out.println("你输入的信息有误，请重新输入");
			}else{
				System.out.println("请重新输入学号");
				Scanner s1 = new Scanner(System.in);
				studentId[temp] = s1.nextInt();
				System.out.println("请重新输入姓名");
				Scanner s2 = new Scanner(System.in);
				studentName[temp] = s2.next();
				System.out.println("请重新输入分数");
				Scanner s3 = new Scanner(System.in);
				studentScore[temp] = s3.nextInt();
				System.out.println("修改完成");
				
			}
		}

	// 5.查询学生信息块
	public static Integer select(Integer[] studentId, String[] studentName,
			Integer[] studentScore, int studentCount) {
		System.out.println("请输入学生姓名");
		Scanner s = new Scanner(System.in);
		String str = s.next();
		for (int i = 0; i < studentCount; i++) {
			if (str.equals(studentName[i]))
				System.out.println("学号"+"\t姓名"+"\t成绩");
				System.out.println(studentId[i] + "\t" + studentName[i] + "\t"
					+ studentScore[i]);
				return studentId[i];
		}
		return null;
		
	}

	

	

	// 6.排序块
	public static void Sort(Integer[] studentId, String[] studentName,
			Integer[] studentScore, int studentCount) {
		System.out.println("请选择排序方法:1.按学号排序\t2.按成绩排序");
		Scanner s1 = new Scanner(System.in);
		int number = s1.nextInt();
		switch (number) {
		case 1:
			for (int i = 0; i < studentCount; i++) {
				for (int j = 0; j < studentCount - 1 - i; j++) {
					if (studentId[j] > studentId[j + 1]) {
						int tp = studentId[j];
						studentId[j] = studentId[j + 1];
						studentId[j + 1] = tp;

						tp = studentScore[j];
						studentScore[j] = studentScore[j + 1];
						studentScore[j + 1] = tp;

						String tp1 = studentName[j];
						studentName[j] = studentName[j + 1];
						studentName[j + 1] = tp1;
					}
				}
			}
			display(studentId, studentName, studentScore, studentCount);
			break;

		case 2:
			for (int i = 0; i < studentCount; i++) {
				for (int j = 0; j < studentCount - 1 - i; j++) {
					if (studentScore[j] > studentScore[j + 1]) {
						int tp = studentScore[j];
						studentScore[j] = studentScore[j + 1];
						studentScore[j + 1] = tp;

						tp = studentId[j];
						studentId[j] = studentId[j + 1];
						studentId[j + 1] = tp;

						String tp1 = studentName[j];
						studentName[j] = studentName[j + 1];
						studentName[j + 1] = tp1;
					}
				}
			}
			display(studentId, studentName, studentScore, studentCount);
			break;
		default:
			System.out.println("请输入1或者2");
		}

	}
}