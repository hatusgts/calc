package telas;

import Integrais.Integrais;
import telas.TelaEscolhaIntegral;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela para cálculo de integrais definidas
 * Permite ao usuário inserir uma função e calcular sua integral entre limites específicos
 *
 * @author Aluno
 */
public class TelaIntegralDefinida extends JFrame {

    // Componentes da interface
    private JTextField campoFuncao;

    private JTextField campoLimiteInferior;
    private JTextField campoLimiteSuperior;
    private JTextArea areaResultado;

    // Botões numéricos (0-9)
    private JButton[] botoesNumeros = new JButton[10];

    // Botões de operações
    private JButton btnIgual, btnSomar, btnSubtrair, btnMultiplicar, btnDividir;
    private JButton btnRaiz, btnParentesesAbre, btnParentesesFecha, btnLimpar, btnPotencia;
    private JButton btnVoltar;

    /**
     * Construtor da tela
     */
    public TelaIntegralDefinida() {
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
        configurarJanela();
    }

    /**
     * Inicializa todos os componentes da interface
     */
    private void inicializarComponentes() {
        // Campos de entrada
        campoFuncao = new JTextField();

        campoLimiteInferior = new JTextField();
        campoLimiteSuperior = new JTextField();

        // Área de resultado
        areaResultado = new JTextArea(5, 20);
        areaResultado.setEditable(false);

        // Inicializar botões numéricos
        for (int i = 0; i < 10; i++) {
            botoesNumeros[i] = new JButton(String.valueOf(i));
        }

        // Botões de operações
        btnIgual = new JButton("=");
        btnSomar = new JButton("+");
        btnSubtrair = new JButton("-");
        btnMultiplicar = new JButton("*");
        btnDividir = new JButton("/");
        btnRaiz = new JButton("√");
        btnParentesesAbre = new JButton("(");
        btnParentesesFecha = new JButton(")");
        btnPotencia = new JButton("^");
        btnLimpar = new JButton("C");
        btnVoltar = new JButton("Voltar");

        // Configurar fonte do botão voltar
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12));
    }

    /**
     * Configura o layout da interface usando GroupLayout
     */
    private void configurarLayout() {
        // Labels
        JLabel lblTitulo = new JLabel("Integral Definida");
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblInstrucao = new JLabel("Insira a função:");
        JLabel lblFuncao = new JLabel("f(x)=");

        JLabel lblInicio = new JLabel("Início:");
        JLabel lblFinal = new JLabel("Final:");

        // ScrollPane para área de resultado
        JScrollPane scrollResultado = new JScrollPane(areaResultado);

        // Configurar GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // Layout horizontal
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        // Título
                                        .addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                        // Campos de entrada
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblFuncao))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblInstrucao)
                                                        .addComponent(campoFuncao, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)))
                                        // Limites de integração
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(lblInicio)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLimiteInferior, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblFinal)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLimiteSuperior, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                        // Teclado numérico
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addGroup(criarLayoutTeclado()))
                                        // Área de resultado
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(56, 56, 56)
                                                .addComponent(scrollResultado, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE))
                                        // Botão voltar
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnVoltar)))
                                .addContainerGap())
        );

        // Layout vertical
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(lblInstrucao)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoFuncao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFuncao))
                                .addGap(18, 18, 18)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(campoLimiteInferior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblInicio)
                                        .addComponent(campoLimiteSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFinal))
                                .addGap(44, 44, 44)
                                .addGroup(criarLayoutVerticalTeclado())
                                .addGap(18, 18, 18)
                                .addComponent(btnVoltar)
                                .addGap(32, 32, 32)
                                .addComponent(scrollResultado, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    /**
     * Cria o layout horizontal do teclado numérico
     */
    private GroupLayout.Group criarLayoutTeclado() {
        GroupLayout layout = (GroupLayout) getContentPane().getLayout();

        return layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                // Primeira linha: 1, 2, 3, +, √
                .addGroup(layout.createSequentialGroup()
                        .addComponent(botoesNumeros[1], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[2], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[3], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSomar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubtrair, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                )
                // Segunda linha: 4, 5, 6, -, (
                .addGroup(layout.createSequentialGroup()
                        .addComponent(botoesNumeros[4], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[5], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[6], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)

                        .addComponent(btnParentesesAbre, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParentesesFecha, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                )
                // Terceira linha: 7, 8, 9, *, )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(botoesNumeros[7], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[8], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[9], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMultiplicar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDividir, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                )
                // Quarta linha: 0, =, /, C
                .addGroup(layout.createSequentialGroup()

                        .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesNumeros[0], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIgual, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRaiz, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPotencia,GroupLayout.PREFERRED_SIZE,51,GroupLayout.PREFERRED_SIZE)
                );
    }

    /**
     * Cria o layout vertical do teclado numérico
     */
    private GroupLayout.Group criarLayoutVerticalTeclado() {
        GroupLayout layout = (GroupLayout) getContentPane().getLayout();

        return layout.createSequentialGroup()
                // Primeira linha
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botoesNumeros[1], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[2], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[3], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSomar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubtrair, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))

                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                // Segunda linha
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botoesNumeros[4], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[5], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[6], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnParentesesAbre, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnParentesesFecha, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                // Terceira linha
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botoesNumeros[7], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[8], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[9], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMultiplicar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDividir, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                // Quarta linha
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botoesNumeros[0], GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIgual, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRaiz, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPotencia,GroupLayout.PREFERRED_SIZE,51,GroupLayout.PREFERRED_SIZE)
                );
    }

    /**
     * Configura os eventos dos componentes
     */
    private void configurarEventos() {
        // Evento do botão igual (calcular integral)
        btnIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIntegral();
            }
        });

        // Evento do botão voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarTelaAnterior();
            }
        });

        // Eventos dos botões numéricos
        for (int i = 0; i < 10; i++) {
            final int numero = i;
            botoesNumeros[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    adicionarTexto(String.valueOf(numero));
                }
            });
        }

        // Eventos dos botões de operação
        btnSomar.addActionListener(e -> adicionarTexto("+"));
        btnSubtrair.addActionListener(e -> adicionarTexto("-"));
        btnMultiplicar.addActionListener(e -> adicionarTexto("*"));
        btnDividir.addActionListener(e -> adicionarTexto("/"));
        btnRaiz.addActionListener(e -> adicionarTexto("√"));
        btnParentesesAbre.addActionListener(e -> adicionarTexto("("));
        btnParentesesFecha.addActionListener(e -> adicionarTexto(")"));
        btnPotencia.addActionListener(e -> adicionarTexto("^"));
        btnLimpar.addActionListener(e -> limparCampos());
    }

    /**
     * Configura as propriedades da janela
     */
    private void configurarJanela() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack(); // Ajusta o tamanho automaticamente
        setLocationRelativeTo(null); // Centraliza a janela
        setTitle("Calculadora de Integrais Definidas");
    }

    /**
     * Adiciona texto ao campo de função que está em foco
     */
    private void adicionarTexto(String texto) {
        JTextField campoAtivo = obterCampoAtivo();
        if (campoAtivo != null) {
            campoAtivo.setText(campoAtivo.getText() + texto);
        }
    }

    /**
     * Obtém o campo de texto que está atualmente em foco
     */
    private JTextField obterCampoAtivo() {
        if (campoFuncao.hasFocus()) return campoFuncao;

        if (campoLimiteInferior.hasFocus()) return campoLimiteInferior;
        if (campoLimiteSuperior.hasFocus()) return campoLimiteSuperior;
        return campoFuncao; // Campo padrão
    }

    /**
     * Limpa todos os campos de entrada
     */
    private void limparCampos() {
        campoFuncao.setText("");

        campoLimiteInferior.setText("");
        campoLimiteSuperior.setText("");
        areaResultado.setText("");
    }

    /**
     * Calcula a integral definida com base nos dados inseridos
     */
    private void calcularIntegral() {
        String expressao = campoFuncao.getText().trim();
        String limiteInferior = campoLimiteInferior.getText().trim();
        String limiteSuperior = campoLimiteSuperior.getText().trim();

        // Validação dos campos obrigatórios
        if (expressao.isEmpty()) {
            areaResultado.setText("Erro: Por favor, insira uma função.");
            return;
        }

        if (limiteInferior.isEmpty() || limiteSuperior.isEmpty()) {
            areaResultado.setText("Erro: Por favor, preencha os limites de integração (Início e Final).");
            return;
        }

        try {
            // Calcula a integral definida
            String resultado = Integrais.calcularIntegralDefinida(expressao, limiteInferior, limiteSuperior);
            areaResultado.setText("Integral Definida de " + limiteInferior + " até " + limiteSuperior + ":\n\n" + resultado);
        } catch (Exception e) {
            areaResultado.setText("Erro no cálculo da integral definida:\n" + e.getMessage());
        }
    }

    /**
     * Volta para a tela de escolha de integral
     */
    private void voltarTelaAnterior() {
        TelaEscolhaIntegral telaEscolha = new TelaEscolhaIntegral();
        dispose(); // Fecha a tela atual
        telaEscolha.setVisible(true); // Mostra a tela anterior
    }

    /**
     * Método principal para execução da aplicação
     */
    public static void main(String[] args) {
        // Configura o Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Executa a aplicação na EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            new TelaIntegralDefinida().setVisible(true);
        });
    }
}