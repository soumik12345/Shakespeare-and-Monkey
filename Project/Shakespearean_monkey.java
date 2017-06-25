import java.util.*;
import java.io.*;
class Shakespearean_monkey
{
    DNA population[];//The DNA of the population
    String target;//The target string that is to be achieved
    ArrayList<DNA> matingPool;//The mating pool for each generation
    float mutationRate;

    Shakespearean_monkey(String s, int p, float m)//target and DNA is initialized
    {
        population=new DNA[p];
        for(int i=0;i<population.length;i++)
            population[i]=new DNA();
        target=s;
        mutationRate=m;
    }

    void process()
    {
        while(true)
        {
            //SELECTION

            //Assigning the fitness value to each member of the population
            for(int i=0;i<population.length;i++)
                population[i].fitness(target);

            ArrayList<DNA> matingPool=new ArrayList<DNA>();//initializing the mating pool as an empty ArrayList
            //Populating the mating pool depending on the fitness of each DNA
            for(int i=0;i<population.length;i++)
            {
                int n=(int)(population[i].fitness*100);//fitness percentage of the mating pool
                for(int j=0;j<n;j++)//adding the particular DNA to the mating pool n times
                    matingPool.add(population[i]);
            }

            //REPRODUCTION
            DNA child=new DNA();
            for(int i=0;i<population.length;i++)
            {
                //choosing two random indices from the matingPool ArrayList
                int a=(int)(Math.random()*(matingPool.size()-1));
                int b=(int)(Math.random()*(matingPool.size()-1));

                //selecting two parents
                DNA parentA=matingPool.get(a);
                DNA parentB=matingPool.get(b);

                child=parentA.crossover(parentB);
                child.mutate(mutationRate);
                population[i]=child;
            }

            System.out.println(child.getPhrase());
            if(target.equals(child.getPhrase()))
                break;
        }
    }

}