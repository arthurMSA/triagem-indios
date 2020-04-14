package br.com.fiap.triagem.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.triagem.dao.InternacaoDAO;
import br.com.fiap.triagem.dao.impl.InternacaoDAOImpl;
import br.com.fiap.triagem.entity.Convenio;
import br.com.fiap.triagem.entity.Internacao;
import br.com.fiap.triagem.entity.Leito;
import br.com.fiap.triagem.entity.ModalidadePlano;
import br.com.fiap.triagem.entity.Paciente;
import br.com.fiap.triagem.entity.PlanoSaude;
import br.com.fiap.triagem.entity.Risco;
import br.com.fiap.triagem.entity.Tipo;
import br.com.fiap.triagem.exception.CommitException;
import br.com.fiap.triagem.singleton.EntityManagerFactorySingleton;

 

public class View {

 

    public static void main(String[] args) {
        //Obter uma instância da fabrica
        EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

        //Instanciar Entity Maneger
        EntityManager em = fabrica.createEntityManager();

        InternacaoDAO dao = new InternacaoDAOImpl(em);
        
        Leito leito = new Leito(1, 1, Tipo.OBSERVACAO);
        
        Paciente paciente = new Paciente("Laura", "12345678901");
        
        Internacao internacao = new Internacao(new GregorianCalendar(2020, Calendar.DECEMBER, 4), 
                Risco.GRAVE, new GregorianCalendar(2020, Calendar.DECEMBER, 9), leito, paciente);
        
        Convenio convenio = new Convenio("Econumus", "12345678901234");
        
        List<PlanoSaude> planos = new ArrayList<PlanoSaude>();
        planos.add(new PlanoSaude("Econumus Plus II", ModalidadePlano.FAMILIAR, convenio));
        planos.add(new PlanoSaude("Econumus Plus I", ModalidadePlano.EMRPESARIAL, convenio));
        paciente.setPlanos(planos);
        
        dao.cadastrar(internacao);
        try {
			dao.commit();
			System.out.println("Deu certo!!!");
		}catch(CommitException e) {
			System.out.println("Não deu certo!!!");
		}
 
        //Fechar
        fabrica.close();
        em.close();
    }
}