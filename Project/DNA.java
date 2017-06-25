class DNA
{
    char gene[]=new char[18];//each element in this gene array represents a new gene
    float fitness;
    int targetLen;
    DNA(int T)
    {
        targetLen=T;
        gene=new char[targetLen];
        for(int i=0;i<gene.length;i++)
            gene[i]=(char)(32+(int)(Math.random()*128));
    }

    void fitness(String target)
    {
        int score=0;
        for(int i=0;i<gene.length;i++)
            if(gene[i]==target.charAt(i))
                score++;
        fitness=((float)(score))/target.length();
    }

    DNA crossover(DNA partner)
    {
        DNA child=new DNA(targetLen);//new DNA for the child
        int midpoint=(int)(Math.random()*(gene.length-1));//selecting a random midpoint in the genes array
        for(int i=0;i<gene.length;i++)
        {
            if(i>midpoint)
                child.gene[i]=gene[i];//child gets gene from the mother DNA
            else
                child.gene[i]=partner.gene[i];//child gets gene from the partner DNA
        }
        return child;
    }

    void mutate(float m)
    {
        float mutationRate=m;
        for(int i=0;i<gene.length;i++)//for eavery gene in the DNA
            if(Math.random()<mutationRate)
                gene[i]=(char)(32+(int)(Math.random()*128));//gene is getting mutated
    }

    String getPhrase()
    {
        return new String(gene);
    }

}
