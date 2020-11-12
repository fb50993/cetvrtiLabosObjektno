package hr.fer.oop.lab4.first;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MultipleFileProgram {

	public static void main(String[] args) {

		Path racuni = Paths.get("./racuni3");
		Path ispisnaDat = Paths.get("./sviRacuni.txt");
		
		if(Files.notExists(ispisnaDat, LinkOption.NOFOLLOW_LINKS)) {
			createFile(ispisnaDat);
		}
		
		try {
			OutputStream os = Files.newOutputStream(ispisnaDat, StandardOpenOption.WRITE);
			FileVisitor<Path> visitor = new MyByteReader(os);
			Files.walkFileTree(racuni, visitor);
			os.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void createFile(Path ispisnaDat) {
		try {
			Files.createFile(ispisnaDat);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
