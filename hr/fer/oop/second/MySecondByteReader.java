package hr.fer.oop.lab4.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySecondByteReader extends SimpleFileVisitor<Path> {

	protected TreeSet<Artikl> artikli;
	
	public MySecondByteReader() {
		this.artikli = new TreeSet<Artikl>();
	}
	
	public TreeSet<Artikl> getArtikli() {
		return artikli;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("readnig file" +file.toString());
		if(file.toString().endsWith("txt")) {
			Artikl a;
			BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(file, LinkOption.NOFOLLOW_LINKS)));
			while(true) {
				String line = br.readLine();
				line.trim();
				if(line.startsWith("UKUPNO")) break;
				else if(!line.isEmpty() && !line.startsWith("Račun br") && !line.startsWith("Kupac") && !line.startsWith("---") && !line.endsWith("---") && !line.startsWith("Proizvod")) {
					String[] parts = line.split("\\s\\s+");
					a = new Artikl(parts[0], parts[1]);
					this.artikli.add(a);
				}
			}	
		}
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		return FileVisitResult.CONTINUE;
	}
}
