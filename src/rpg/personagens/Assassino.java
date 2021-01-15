package rpg.personagens;

import java.util.ArrayList;
import java.util.List;
import rpg.ataquesespeciais.Ataques;
import rpg.ataquesespeciais.TipoDoAtaque;

public class Assassino extends Personagem{
	private Ataques attSp = new Ataques("Finalização", TipoDoAtaque.valueOf("AD"));
	private Ataques attBasics = new Ataques("Auto-Ataque", TipoDoAtaque.valueOf("AD"));
	public List <Integer> attEspecial = new ArrayList<>();
	public Assassino(String nomeChar) {
		super(nomeChar);
		pontosDeVida = 150;
		poderDeHabilidade = 0;
		poderAtaqueFisico = 40;
		armadura = 20;
		resistenciaMagica = 15;
		ataqueEspecial = attSp;
		ataqueBasico = attBasics;
                pontosHabilidade = 0;
		tipo = TiposDePersonagem.valueOf("ASSASSINO");
	}
	
        @Override
	public void ataqueEspecial() {
            
            if(pontosHabilidade == 1){
                pontosHabilidade = 0;
                
                int aux = (int) (0.15 * poderAtaqueFisico);
                
                int poderAtaqueFisicoEspecial = aux + poderAtaqueFisico;
                //int pontosDeVidaEspecial = 0;
                //int armaduraEspecial = 0;
                //int resistenciaMagicaEspecial = 0;
                int poderDeHabilidadeEspecial = 0;
                

                attEspecial.clear();
                attEspecial.add(poderAtaqueFisicoEspecial);
                //attEspecial.add(pontosDeVidaEspecial);
                //attEspecial.add(armaduraEspecial);
                //attEspecial.add(resistenciaMagicaEspecial);
                attEspecial.add(poderDeHabilidadeEspecial);
            } else {
                 System.out.println("Sua habilidade especial ainda não está pronta.\n");
            }
	}
        
        @Override
        public List<Integer> getAtaqueDoAtaqueEspecial(){
            return attEspecial;
        }
	
	@Override
	public void powerUp() {
		poderAtaqueFisico += 0.08 * poderAtaqueFisico;
		armadura += 0.08 * armadura;
		resistenciaMagica += 0.08 * resistenciaMagica;
		poderDeHabilidade += 0.08 * poderDeHabilidade;
                pontosHabilidade += 1;
	}
	
	@Override
	public void mostrarDados() {
		System.out.println(nomeChar +" - " + "Lutador" + "\nPontos de Vida: " + pontosDeVida + "\nPoder de Habilidade: " + poderDeHabilidade 
				+ "\nPoder do Ataque Físico: " + poderAtaqueFisico + "\nArmadura: " + armadura + "\nResistência Mágica: " + resistenciaMagica + 
				"\nAtaque Especial: " + ataqueEspecial + "\nPontos de habilidade: " + pontosHabilidade);
	}
}
