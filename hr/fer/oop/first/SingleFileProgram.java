package hr.fer.oop.lab4.first;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class SingleFileProgram {

	public static void main(String[] args) throws IOException {
		
		Path fileToRewrite = Paths.get("./racuni3/2015/9/Racun_8.txt");
		Path result = Paths.get("./singleout.txt");
		
		try(InputStream is = Files.newInputStream(fileToRewrite, StandardOpenOption.READ)) {
			
			MyByteWriter rewriter = new MyByteWriter(is, result);
			rewriter.run();
			System.out.println(filesEquals(fileToRewrite, result));
			
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}

	public static boolean filesEquals(Path fileToRewrite, Path result) throws IOException {
		return Arrays.equals(Files.readAllBytes(fileToRewrite), Files.readAllBytes(result));
	}
}
