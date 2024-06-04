package com.lld.structural.composite;

public class Client {
		
	public static void main(String[] args) {
		File file = new File("Sample.txt");
		
		file.display();
		
		
		Directory dir = new Directory("Main");
		
		File file1 = new File("Sample1.txt");
		File file2 = new File("Sample2.txt");
		File file3 = new File("Sample3.txt");
		
		Directory subDir = new Directory("Sub");
		File file4 = new File("Sample4.txt");
		subDir.add(file4);
		
		dir.add(file1);
		dir.add(file2);
		dir.add(file3);
		dir.add(subDir);
		
		dir.display();
	}

}
