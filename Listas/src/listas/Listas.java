package listas;
public class Listas {
    private String lista[];

    private int tamanho;   

/*construtor  irá requer o tamanho do arranjo neste caso 10 
posições  e a variável tamanho onde inicializará o arranjo*/

    public Listas(){
        lista=new String [10];
        tamanho=0;
    }
    
    /*método de auxilio utilizado para verificar caso a lista esteja 
    vazia ,caso tamanho seja igual a zero a  lista está vazia*/

    public boolean vazia (){
        return tamanho==0;
    }
    
    /*método de auxílio utilizado para verificar caso a lista esteja 
    cheia ,caso tamanho seja igual a 10 a lista está cheia.*/

    public boolean cheia (){
        return tamanho == lista.length;
    }
    
    /*Este método será utilizado pelo usuário verificar o conteúdo do arranjo.*/
    public void pecorrer(){
        for(int i=0;i<tamanho;i++){
            System.out.print(" "+ lista[i]+" ,");   
        }
        System.out.println(" ");
    }
    
    /*Adicionar elemento ao final da lista.*/
    //parâmetro “x” será referente ao  dado a ser inserido na lista.
    public void adicionafinal (String x){
        //devemos sempre devemos verificar se a lista está cheia através do método .
        if(!cheia()){
            lista[tamanho]=x;
            tamanho++;  // adiciona uma casa  aumentando o  tamanho  do arranjo.
        }else{
            System.out.print("Lista cheia!!");
        }  
    }
    
   /*Adicionar elemento  no inicio da lista*/ 
   public void adicionainicio(String  x){
        if(!cheia()){ // método verifica se lista está cheia
           for(int i=tamanho;i>=1;i--){     
               lista[i]=lista[i-1];  //  aloca o elemento um índice a frente
           }
           tamanho++;// adiciona uma    casa  aumentando o  tamanho  do arranjo.
           lista[0]=x; //inserindo o novo elemento
        }else{
            System.out.println("lista cheia!!"); 
        }
    }
   
   /*Adiciona elemento em qualquer posição da lista*/
    public void qualquePosicao (String x,  int y){  //”x” é referente ao elemento e” y “a posição a ser inserida
        if(cheia()){ //verifica se a lista  cheia.
            System.out.println("Lista cheia");
        }else{
           if(y==0){   // verifica se a posição encontra se  no inicio do da lista
            adicionainicio(x);  // método adiciona  no inicio será utilizado.
           }else{
                if(y>tamanho){ //caso seja maior que tamanho está for a da lista.
                    System.out.println("Erro posição inválida");
                }else{
                    for(int i=tamanho; i>=y;i--){ // estrutura de laço decrementa até o até a posição a ser inserida.
                        lista[i]=lista[i-1];
                    }
                lista[y]=x; // inserção de elemento no arranjo
                tamanho++; // adição de uma casa no arranjo
                }
            }
        }
    }
    
    public void remove(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            System.out.println("Posição inválida");
	}
	for (int i=posicao; i<this.tamanho-1; i++){
            lista[i] = lista[i+1];
	}
	tamanho--;
    }
   
    public int busca(String elemento){
        for (int i=0; i<tamanho; i++){
            if (lista[i].equals(elemento)){
		return i;
            }
	}
	return -1;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Listas l = new Listas();
       l.adicionainicio("A");
       l.adicionainicio("B");
       l.pecorrer();
       l.adicionafinal("C");
       l.pecorrer();
       l.qualquePosicao("D", 1);
       l.pecorrer();
       l.remove(1);
       l.pecorrer();
       System.out.println("Posicao: " + l.busca("A"));
       
    }
}
  
