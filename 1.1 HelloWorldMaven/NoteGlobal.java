/* DEMARRAGE PROJET : maven archetype -> config quickstart*/

/*FAIRE UN  PACKAGE HELLO AVEC UNE CLASSE GREETER QUI SERIVIRA DE SERVICE
ET UNE CLASSE HELLOWROLD QUI AFFICHERA */

package hello;

public class HelloWorld {
  public static void main(String[] args) {
    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}


package hello;

public class Greeter {
  public String sayHello() {
    return "Hello world!";
  }
}

/*COMMANDE MAVEN*/

/*

mvn -v -> permet de savoir si maven est bien installer et indique la version de mavenµ

mvn -clean -> clean le projet et donc supprime le package target qui contient les classes compilee ainsi que les potentiels .jar

mvn -compile -> compile les classes .java en .class dans le repertoire target

mvn -test -> effectue les test

mvn -package -> cree les .jar 

-mvn install -> install la librairie dans le repertoire m2 en .jar 

IMPORTANT : maven fonctionne en cycle cad que quandd vous faites en mvn compile un mvn clean sera fait avant si vous faites mvn -package mvn clean sera fait, mvn -compile, etc

*/


//AJOUTER CA AU POM//

<properties>
    <maven.compiler.source>17</maven.compiler.source> //attention j'utilise java 17 comme jdk remplacer 17 par votre version de java (java -version)
    <maven.compiler.target>17</maven.compiler.target>
</properties>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.2.4</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                    <configuration>
                        <transformers>
                            <transformer
                                implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                <mainClass>hello.HelloWorld</mainClass>
                            </transformer>
                        </transformers>
                    </configuration>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>

/*le plugin shade permet de creer 2 jar, un jar normal : celui ci ira chercher les depandances dynamiquement
 dans le repertoire m2 ou sur internet si les depandance ne sont pas en local, un jar original sera creer avec les dependances embarquees
 plus volumineux mais utile si on veut utilise le jar sur une machine sans maven et donc sans repertoire m2 ou sans internet
 (donc incapable d'aller les chercher)*/


 /*DEPENDANCES*/

 //ajouter ca au pom 

<dependency>
	<groupId>joda-time</groupId> // nom de l'organisation
	<artifactId>joda-time</artifactId> //libraire dans maven centrale
	<version>2.9.2</version> //version
</dependency>


//une fois maven recharger il ira voir localement dans le repertoire m2 si la dependances existe et sinon il ira les chercher sur internet

/*TEST*/

//ajouter ca si ce n'est fait

<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>

//attention si on laisse le scope la depances sera uniqement disponible dans un fichier nomme "test" dans le repertoire source du projet

//se placer dans dans test/java et ecrire un test

package hello;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class GreeterTest {
  
  private Greeter greeter = new Greeter();

  @Test
  public void greeterSaysHello() {
    assertThat(greeter.sayHello(), containsString("Hello"));
  }

}

// l'annontation test permet de specifier au framewrok junit que l'on fait un test ici

//assertThat est une methode qui permet de realiser dans test ici on regarde si la methode sayHello de greeter contient bien "hello"





