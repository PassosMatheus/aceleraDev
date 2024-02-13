package stefanini.aceleradev.api.venda;

public class SaleRequest {
    public class saleRequest {
        private String usuario_nome;
        private String produto_nome;
        private int quantidade;

        public saleRequest(String usuario_nome, String produto_nome, int quantidade) {
            this.usuario_nome = usuario_nome;
            this.produto_nome = produto_nome;
            this.quantidade = quantidade;
        }

        public String getUserName() {
            return usuario_nome;
        }

        public void setUserName(String userName) {
            this.usuario_nome = userName;
        }

        public String getProductName() {
            return produto_nome;
        }

        public void setProductName(String productName) {
            this.produto_nome = productName;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantity) {
            this.quantidade = quantity;
        }
    }

}
