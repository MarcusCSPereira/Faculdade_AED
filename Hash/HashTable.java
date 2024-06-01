import java.util.LinkedList;
// Classe que representa a tabela hash
public class HashTable<K, V> {
   
        private LinkedList<HashNode<K, V>>[] tabelaHash;
        private int m; // Tamanho da tabela
        private int size; // Número de elementos na tabela
       
        // Construtor
        @SuppressWarnings("unchecked")
        public HashTable(int m) {
            this.m = m;
            tabelaHash = new LinkedList[m];
           
            // Inicializa cada posição da tabela com uma lista vazia
            for (int i = 0; i < m; i++) {
                tabelaHash[i] = new LinkedList<>();
            }
            size = 0;
        }
       
        // Função hash
        private int hash(K key) {
            int hashCode = key.hashCode();
            int index = Math.abs(hashCode % m);
            return index;
        }
       
        // Método para adicionar um par chave-valor na tabela
        public void insere(K key, V value) {
            int index = hash(key);
            LinkedList<HashNode<K, V>> chain = tabelaHash[index];
           
            for (int i = 0; i < chain.size(); i++) {
                HashNode<K, V> node = chain.get(i);
                if (node.key.equals(key)) {
                    node.value = value; // Atualiza o valor se a chave já existir
                    return;
                }        
            }            
            // Adiciona um novo nó na lista encadeada
            chain.add(new HashNode<>(key, value));
            size++;
        }
       
        // Método para obter o valor associado a uma chave
        public V get(K key) {
            int index = hash(key);
            LinkedList<HashNode<K, V>> chain = tabelaHash[index];
            for (int i = 0; i < chain.size(); i++) {
              HashNode<K, V> node = chain.get(i);    
              if (node.key.equals(key)) {
                 return node.value;
              }
            }        
            return null; // Retorna null se a chave não for encontrada
        }
       
        // Método para remover um par chave-valor da tabela
        public V remove(K key) {
            int index = hash(key);
            LinkedList<HashNode<K, V>> chain = tabelaHash[index];
            for (int i = 0; i < chain.size(); i++) {
                HashNode<K, V> node = chain.get(i);
                if (node.key.equals(key)) {
                    V value = node.value;
                    chain.remove(node);
                    size--;
                    return value;
                }
            }
           
            return null; // Retorna null se a chave não for encontrada
        }
       
        // Método para obter o número de elementos na tabela
        public int size() {
            return size;
        }
       
        // Método para verificar se a tabela está vazia
        public boolean isEmpty() {
            return size == 0;
        }
       
        @SuppressWarnings("hiding")
        class HashNode<K, V> {
            K key;
            V value;
           
            // Construtor
            public HashNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

    }