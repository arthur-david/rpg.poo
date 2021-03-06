package rpg.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg.personagens.Assassino;
import rpg.personagens.Lutador;
import rpg.personagens.Mago;
import rpg.personagens.Personagem;
import rpg.personagens.Tanque;
import rpg.personagens.TiposDePersonagem;

public class Carregar {
	@SuppressWarnings("resource")
	public Personagem load(String nomeArquivo){
        
		//Substituir endere�o aqui
        String arquivo = nomeArquivo + ".txt";

        try{
            File arq = new File(arquivo);
            Scanner s = new Scanner(arq);
            String tipo = s.nextLine();
            String nome = s.nextLine();
            
            if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.MAGO)) {
                 s.close();
            	 return new Mago(nome);
            } else if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.ASSASSINO)) {
                 s.close();
            	 return new Assassino(nome);
            } else if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.LUTADOR)) {
                 s.close();
            	 return new Lutador(nome);
            } else if(TiposDePersonagem.valueOf(tipo).equals(TiposDePersonagem.TANQUE)) {
                 s.close();
            	 return new Tanque(nome);
            } else {
            	s.close();
            	return null;
            }
            
        }
        catch(Exception e){
            System.out.println("Erro ao carregar personagem!\n");
            System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
        }
		return null;
    }

    @SuppressWarnings("resource")
	public void listarPersonagens(){
    	String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	if(lista.exists() && lista.length() > 0) {
    		try{
    			Scanner s = new Scanner(lista);
                System.out.println("\n***Lista de personagens***\n\n");
                while(s.hasNextLine()){
                    System.out.println(" - " + s.nextLine());
                }
                System.out.println("\n\n");

                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
                s.close();
            }
            catch(Exception e){
                System.out.println("Erro ao ler lista de personagens!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
            }
    	} else {
    		System.out.println("\nSem personagens salvos!\n");
    		System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
    	}
       }
    
    @SuppressWarnings("resource")
	public Personagem selecaoPersonagem(){
    	//Substituir endere�o aqui
    	String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	if(lista.exists() && lista.length() > 0) {
    		try {
    			StringBuilder sb = new StringBuilder();
        		Scanner ler = new Scanner(System.in);
        		Personagem p = null;
        		List <String> nomesPersonagens = new ArrayList<>();
        		String aux;
    			Scanner s = new Scanner(lista);
    			int cond = 1;
    			System.out.println("\n----------------------------------------\n");
    			while(s.hasNextLine()) {
    				aux = s.nextLine();
    				System.out.println(cond + " - " + aux);
    				sb.append(cond + " - " + aux + "\n");
    				nomesPersonagens.add(aux);
    				cond += 1;
    			}
    			System.out.println("\n----------------------------------------\n");
    			System.out.print("\nSelecione qual personagem voc� quer carregar com base nos n�meros: ");
    			int pers = ler.nextInt();
    			while(true) {
    				if((pers-1) < 0 || (pers-1) > nomesPersonagens.size()) {
    					System.out.println("\nValor inv�lido.. Digite um valor v�lido!");
    					System.out.println("\n----------------------------------------\n");
    					System.out.println(sb.toString());
    					System.out.println("----------------------------------------\n");
    	    			System.out.print("\nSelecione qual personagem voc� quer carregar com base nos n�meros: ");
    	    			pers = ler.nextInt();
    				} else {
    					break;
    				}
    			}
    			
    			String name = nomesPersonagens.get(pers-1);
    			p = load(name);
    			return p;
        	}
        	catch(Exception e) {
        		System.out.println("\nErro ao carregar personagem!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        	}
    	} else {
    		System.out.println("\nSem personagens salvos para carregar no jogo!\n");
    		System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
            return null;
    	}
		return null;
    }
    
    public Integer nomeRepetido(List <Personagem> personagem, Personagem k) {
    	Integer cond = 0;
    	for (Personagem p: personagem) {
    		if(p.getNomeChar().equals(k.getNomeChar())) {
    			cond = 1;
    		}
    	}
    	return cond;
    }
    
    @SuppressWarnings("resource")
	public Integer nomeJaCriado(String name) {
    	String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	int cond = 0;
    	if(lista.exists() && lista.length() > 0) {
    		try {
        		List <String> nomesPersonagens = new ArrayList<>();
        		String aux;
        		Scanner s = new Scanner(lista);
        		while(s.hasNextLine()) {
        			aux = s.nextLine();
        			nomesPersonagens.add(aux);
            	}
            	for(String p : nomesPersonagens) {
            		if(p.equals(name)) {
            			cond = 1;
            		} else {
            			cond = 0;
            			}
            	}
        		return cond;
        	}
        	catch(Exception e) {
        		System.out.println("Erro ao ler lista de personagens!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        	}
    	}
		return cond;
    }
    
    @SuppressWarnings("resource")
	public List<String> personagensSalvos(){
    	String listaPersonagens = "Lista de Personagens.txt";
    	File lista = new File(listaPersonagens);
    	if(lista.exists() && lista.length() > 0) {
    		try {
        		List <String> nomesPersonagens = new ArrayList<>();
        		String aux;
    			Scanner s = new Scanner(lista);
    			while(s.hasNextLine()) {
    				aux = s.nextLine();
    				nomesPersonagens.add(aux);
    			}
    			return nomesPersonagens;
        	}
        	catch(Exception e) {
        		System.out.println("\nErro ao carregar personagem!\n");
                System.out.println("Pressione ENTER para continuar...");
                new java.util.Scanner(System.in).nextLine();
        	}
    	} else {
    		System.out.println("\nSem personagens salvos!\n");
    		System.out.println("Pressione ENTER para continuar...");
            new java.util.Scanner(System.in).nextLine();
            return null;
    	}
		return null;
    }
    }

