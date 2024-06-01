public class HashAberto<K, V> {

    private static final int CAPACIDADE = 11;
    private K[] keys;
    private V[] values;
    private int size;
    private int capacidade;
    private int sondagem;

    @SuppressWarnings("unchecked")
    public HashAberto(int sondagem) {
        this.capacidade = CAPACIDADE;
        this.keys = (K[]) new Object[capacidade];
        this.values = (V[]) new Object[capacidade];
        this.sondagem = sondagem;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % capacidade);
    }

    private int sondagemLinear(int index, int tentativa) {
        return (index + tentativa) % capacidade;
    }

    private int sondagemQuadratica(int index, int tentativa) {
        return (index + tentativa * tentativa) % capacidade;
    }

    private int sondagemDupla(int index, K key, int tentativa) {
        int hash1 = hash(key);
        int hash2 = 1 + Math.abs(key.hashCode() % (capacidade - 1));
        return (hash1 + tentativa * hash2) % capacidade;
    }

    private int calcularIndice(int index, K key, int tentativa) {
        switch (sondagem) {
            case 1:
                return sondagemLinear(index, tentativa);
            case 2:
                return sondagemQuadratica(index, tentativa);
            case 3:
                return sondagemDupla(index, key, tentativa);
            default:
                throw new IllegalArgumentException("Tipo de sondagem não suportado");
        }
    }

    public void put(K key, V value) {
        int tentativa = 0;
        int index = hash(key);
        while (keys[calcularIndice(index, key, tentativa)] != null) {
            if (keys[calcularIndice(index, key, tentativa)].equals(key)) {
                values[calcularIndice(index, key, tentativa)] = value;
                return;
            }
            tentativa++;
        }
        keys[calcularIndice(index, key, tentativa)] = key;
        values[calcularIndice(index, key, tentativa)] = value;
        size++;
    }

    public V get(K key) {
        int tentativa = 0;
        int index = hash(key);
        while (keys[calcularIndice(index, key, tentativa)] != null) {
            if (keys[calcularIndice(index, key, tentativa)].equals(key)) {
                return values[calcularIndice(index, key, tentativa)];
            }
            tentativa++;
        }
        return null;
    }

    public V remove(K key) {
        int tentativa = 0;
        int index = hash(key);
        while (keys[calcularIndice(index, key, tentativa)] != null) {
            if (keys[calcularIndice(index, key, tentativa)].equals(key)) {
                V value = values[calcularIndice(index, key, tentativa)];
                keys[calcularIndice(index, key, tentativa)] = null;
                values[calcularIndice(index, key, tentativa)] = null;
                size--;
                return value;
            }
            tentativa++;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}