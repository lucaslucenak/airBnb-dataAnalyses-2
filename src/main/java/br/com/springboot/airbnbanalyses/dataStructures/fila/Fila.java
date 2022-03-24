package br.com.springboot.airbnbanalyses.dataStructures.fila;

public class Fila {

    private String [] arrayList;
    private int tail = -1;

    public Fila(int size){
        this.arrayList = new String[size];
    }

    public void add(String element, int position)  {

        /**
         * CondiÃ§Ãµes para inserir na Lista:
         * 1. a lista nÃ£o deve estar cheia
         */
        if (!isFull()){
            tail++;
            switch (position){
                //adiciona elemento no fim da lista
                case -1:
                    this.arrayList[tail] = element;
                    break;

                //adiciona elemento no inicio da lista
                //todos os outros elementos terÃ£o que andar para as posiÃ§Ãµes posteriores
                case 0:
                    for(int i=getTail();i>0;i--){
                        this.arrayList[i]=this.arrayList[i-1];
                    }
                    this.arrayList[0]=element;
                    break;

                //adiciona elemento na posiÃ§Ã£o passada pelo usuÃ¡rio
                //se a posiÃ§Ã£o passada pelo usuÃ¡rio for maios que o fim da lista,
                //insere no fim da lista.
                default:
                    if (position>=tail){
                        add(element, -1);
                    }
                    else {
                        for(int i=getTail();i>position;i--){
                            this.arrayList[i]=this.arrayList[i-1];
                        }
                        this.arrayList[position]=element;
                    }
                    break;
            }
        }

    }

    public void remove(int position) {

        /**
         * CondiÃ§Ãµes para remover item da Lista:
         * 1. A lista nÃ£o deve estar VAZIA
         */
        if (!isEmpty()){
            switch (position){
                //remove elemento no fim da lista
                case -1:
                    break;

                //remove elemento no inicio da lista
                //todos os outros elementos terÃ£o que andar para as posiÃ§Ãµes anteriores
                case 0:
                    for(int i=0;i<getTail();i++){
                        this.arrayList[i]=this.arrayList[i+1];
                    }
                    break;

                //remove elemento na posiÃ§Ã£o passada pelo usuÃ¡rio
                default:
                    if (position<tail){
                        for(int i=position;i<=getTail();i++){
                            this.arrayList[i]=this.arrayList[i+1];
                        }
                    }
                    break;
            }
            this.arrayList[tail] = null;
            tail--;
        }

    }

    public boolean isEmpty() {
        if (this.arrayList[0]==null)
            return true;
        return false;
    }

    public boolean isFull(){
        if (this.arrayList[arrayList.length-1]!=null)
            return true;
        return false;
    }

    public int size() {
        return this.getTail()+1;
    }

    public String show(int position) {
        if (!isEmpty() && position<=tail)
            return this.arrayList[position];
        else if (position>tail){
            return "PosiÃ§Ã£o InvÃ¡lida";
        }
        else
            return "Lista Vazia";
    }

    public void print(){
        for(int i=0;i<=getTail();i++){
            System.out.println("Objeto posiÃ§Ã£o: " + i + " - valor: " + arrayList[i]);
        }
    }

    public int getTail() {
        return tail;
    }

}