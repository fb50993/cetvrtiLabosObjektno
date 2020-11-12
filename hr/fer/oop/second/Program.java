package hr.fer.oop.lab4.second;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		Path racuni = Paths.get("./racuni3");
		
		try {
			FileVisitor<Path> visitor = new MySecondByteReader();
			Files.walkFileTree(racuni, visitor);
			TreeSet<Artikl> artikli1 = ((MySecondByteReader) visitor).getArtikli();
			Writer bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("./cjenik.88592.txt")), "ISO-8859-2"));
			Writer bw1 = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("./cjenik.utf8.txt")), "UTF-8"));
			
			for(Artikl a: artikli1) {
				System.out.println(a.getNaziv()+"\t"+a.getCijena());
				bw.write(a.getNaziv()+"\t"+a.getCijena()+"\n");
				bw1.write(a.getNaziv()+"\t"+a.getCijena()+"\n");
			}
			
			bw.close();
			bw1.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
