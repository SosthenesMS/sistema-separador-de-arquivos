package br.com.sosthenesmendonca.separadordearquivos.Servicies;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.FileSystemUtils;



public class SeparadorService {

	public void obterArquivos() throws IOException {
		InputStream in;
		OutputStream out;

		File folder = new File("C:/Users/Public/Documents/DiretorioTeste-Separador");

		File[] listaDeArquivos = folder.listFiles();
		Set<String> extensoes = new HashSet<>();

		// OBTER OS NOMES DAS EXTESÕES PARA CRIAR AS PASTAS
		for (File file : listaDeArquivos) {

			String nomeArquivo = file.getName();
			int lastDotIndex = nomeArquivo.lastIndexOf('.');

			if (lastDotIndex != -1 && lastDotIndex < nomeArquivo.length() - 1) {
				String ext = nomeArquivo.substring(lastDotIndex + 1);
				extensoes.add(ext);
			}

		}

		System.out.println(extensoes.toString());
		
		
		// CRIAÇÃO DAS NOVAS PASTAS
		for (String ex : extensoes) {
			File novaPasta = new File("C:/Users/Public/Documents/DiretorioTeste-Separador/" + ex);
			novaPasta.mkdir();

		}

		
		
		for (File file : listaDeArquivos) {

			String ext = "";
			String nomeArquivo = file.getName();
			//System.out.println("nomeArquivo >>> " + nomeArquivo);
			File origem = new File("C:/Users/Public/Documents/DiretorioTeste-Separador/" + nomeArquivo);
			
			int lastDotIndex = nomeArquivo.lastIndexOf('.');
			if (lastDotIndex != -1 && lastDotIndex < nomeArquivo.length() - 1) {
				ext = nomeArquivo.substring(lastDotIndex + 1);
			}
			
			File destino = new File("C:/Users/Public/Documents/DiretorioTeste-Separador/" + ext + "/");
			
			moverArquivos(origem, destino);

		}
		
		System.out.println("Total de arquivos organizados -> " + listaDeArquivos.length);
	

	}
	
	
	
	public void moverArquivos(File origemDir, File destinoDir) throws IOException {
		
	    var arquivo = origemDir.getAbsoluteFile();
	    
	  
	    if (arquivo != null) {
	    	
	    	if (arquivo.isFile()) {
                File destino = new File(destinoDir, arquivo.getName());
                
                if (arquivo.renameTo(destino)) {
                    System.out.println("Arquivo movido com sucesso: " + arquivo.getName());
                    
                } else {
                	
                    System.out.println("Falha ao mover o arquivo: " + arquivo.getName());
                }
            }

	            
	     }
	}
}









