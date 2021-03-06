package com.example.location;

import com.example.location.DAO.IClient;
import com.example.location.DAO.IVehicule;
import com.example.location.DAO.ICategory;
import com.example.location.entities.Client;
import com.example.location.entities.Vehicule;
import com.example.location.entities.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import net.bytebuddy.utility.RandomString;

import java.util.Random;

@SpringBootApplication
public class LocationApplication implements CommandLineRunner {
    @Autowired
    private IVehicule iVehicule;
    @Autowired
    private ICategory iCategory;
    @Autowired
    private IClient iClient;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LocationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Vehicule.class, Category.class, Client.class);

        //Clients de depart
        //SuperAdmin
        Client client1=new Client("Marah","Abdel","marah@gmail.com","MTIz","Nancy",101111,"SUPADMIN");
        Client client2= new Client("Chaoub","Rayane","rayane@gmail.com","MTIz","Vandeouvre-Les-Nancy",202222,"SUPADMIN");
        iClient.save(client1);
        iClient.save(client2);
        //Admin
        iClient.save(new Client("ElAlaoui","Rachid","rachid@gmail.com","MTIz","Nancy",303333,"ADMIN"));
        iClient.save(new Client("Rehaily","Rida","rida@gmail.com","MTIz","Vandeouvre-Les-Nancy",404444,"ADMIN"));
        //ClientNormal
        iClient.save(new Client("Test","Test","mar7aba@gmail.com","MTIz"));

        //Categories
        iCategory.save(new Category("KlaKaDos - Bondex","KlaKaDos - Bondex.JPG"));
        iCategory.save(new Category("KlaKaDos - V33","KlaKaDos - V33.JPG"));
        iCategory.save(new Category("KlaKaDos - Cecil","KlaKaDos - Cecil.JPG"));
        iCategory.save(new Category("KlaKaDos - Liberon","KlaKaDos - Liberon.JPG"));

        //Vehicules
        Random rnd=new Random();
        final int[] NumProduit = {1};
        iCategory.findAll().forEach(c->{
            for (int i = 0; i <2 ; i++) {
                Vehicule v=new Vehicule();
                v.setName(RandomString.make(20));
                v.setMarque(c.getName());
//                v.setMarque(RandomString.make(6));
                v.setEnergie(RandomString.make(6));
                v.setNbPlaces(2+rnd.nextInt(7));
                v.setKilometrage(50000+rnd.nextInt(200000));
                v.setBoiteAvitesse("Manuelle");
                v.setMoteurCapacite("0,5L - "+1+rnd.nextInt(11)+"L");
                v.setPuissance(80+rnd.nextInt(150));
                v.setCurrentPrice(10+rnd.nextInt(100));
                v.setVille("Nancy");
                v.setCategory(c);
                v.setClient(client1);
                v.setPhotoName("p"+ NumProduit[0]++ +".JPG");
                iVehicule.save(v);
            }
        });
        iCategory.findAll().forEach(c->{
            Vehicule v=new Vehicule();
            v.setName(RandomString.make(20));
            v.setMarque(c.getName());
//            v.setMarque(RandomString.make(6));
            v.setEnergie(RandomString.make(6));
            v.setNbPlaces(2+rnd.nextInt(7));
            v.setKilometrage(50000+rnd.nextInt(200000));
            v.setBoiteAvitesse("Manuelle");
            v.setMoteurCapacite("0,5L - "+1+rnd.nextInt(11)+"L");
            v.setPuissance(80+rnd.nextInt(150));
            v.setCurrentPrice(10+rnd.nextInt(100));
            v.setVille("Vandeouvre-Les-Nancy");
            v.setCategory(c);
            v.setClient(client2);
            v.setPhotoName("p"+ NumProduit[0]++ +".JPG");
//            v.setPhotoName(c.getPhoto());
            iVehicule.save(v);
        });
    }




}
