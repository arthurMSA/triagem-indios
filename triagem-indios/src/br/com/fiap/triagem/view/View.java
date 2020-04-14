package br.com.fiap.triagem.view;

 

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

 

import br.com.fiap.triagem.entity.Convenio;
import br.com.fiap.triagem.entity.Internacao;
import br.com.fiap.triagem.entity.Leito;
import br.com.fiap.triagem.entity.ModalidadePlano;
import br.com.fiap.triagem.entity.Paciente;
import br.com.fiap.triagem.entity.PlanoSaude;
import br.com.fiap.triagem.entity.Risco;
import br.com.fiap.triagem.entity.Tipo;
import br.com.fiap.triagem.singleton.EntityManagerFactorySingleton;

 

public class View {

 

    public static void main(String[] args) {
        //Obter uma instância da fabrica
        EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

        //Instanciar Entity Maneger
        EntityManager em = fabrica.createEntityManager();

        
        Leito leito = new Leito(1, 1, Tipo.OBSERVACAO);
        
        Paciente paciente = new Paciente("Laura", "12345678901");
        
        Internacao internacao = new Internacao(new GregorianCalendar(2020, Calendar.DECEMBER, 4), 
                Risco.GRAVE, new GregorianCalendar(2020, Calendar.DECEMBER, 9), leito, paciente);
        
        Convenio convenio = new Convenio("CU", "12345678901234");
        
        PlanoSaude plano = new PlanoSaude("Econumus", ModalidadePlano.FAMILIAR, convenio);
        
        

        //CADASTRAR INTERNACAO E PLANO
        em.persist(internacao);
        em.persist(plano);
        
        
        em.getTransaction().begin();
        em.getTransaction().commit();

 

        //Fechar
        fabrica.close();
        em.close();
    }
}