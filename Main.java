
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JLabel labelJudul;
    private JLabel labelNIM;
    private JLabel labelNama;
    private JLabel labelHasil;
    private JTextField fieldNIM;
    private JTextField fieldNama;
    private JButton tombolSimpan;
    private JButton tombolReset;
    private JPanel panelUtama;
    private JPanel panelForm;
    private JPanel panelBawah;
    private JPanel panelTombol;

    public Main() {
        setTitle("Formulir Pendaftaran Mahasiswa");
        setSize(500, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        panelUtama = new JPanel(new BorderLayout(10, 15));
        panelUtama.setBorder(BorderFactory.createEmptyBorder(25, 30, 20, 30));

        labelJudul = new JLabel("FORMULIR PENDAFTARAN MAHASISWA", SwingConstants.CENTER);

        labelJudul.setFont(new Font("Arial", Font.BOLD, 17));

        panelForm = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        labelNIM = new JLabel("NIM:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        panelForm.add(labelNIM, gbc);

        fieldNIM = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        panelForm.add(fieldNIM, gbc);

        labelNama = new JLabel("Nama Mahasiswa:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panelForm.add(labelNama, gbc);

        fieldNama = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        panelForm.add(fieldNama, gbc);

        panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        tombolSimpan = new JButton("Simpan");
        tombolReset = new JButton("Reset");

        tombolSimpan.setPreferredSize(new Dimension(100, 35));

        tombolReset.setPreferredSize(new Dimension(100, 35));

        panelTombol.add(tombolSimpan);
        panelTombol.add(tombolReset);

        labelHasil = new JLabel("Silakan isi formulir terlebih dahulu.", SwingConstants.CENTER);

        labelHasil.setFont(new Font("Arial", Font.PLAIN, 12));

        panelBawah = new JPanel(new BorderLayout(5, 5));
        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(labelHasil, BorderLayout.SOUTH);

        tombolSimpan.addActionListener(this);
        tombolReset.addActionListener(this);

        panelUtama.add(labelJudul, BorderLayout.NORTH);
        panelUtama.add(panelForm, BorderLayout.CENTER);
        panelUtama.add(panelBawah, BorderLayout.SOUTH);

        add(panelUtama);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolSimpan) {
            String nim = fieldNIM.getText().trim();
            String nama = fieldNama.getText().trim();

            if (nim.isEmpty() || nama.isEmpty()) {
                JOptionPane.showMessageDialog(this, "NIM dan Nama harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                labelHasil.setText("Data berhasil disimpan: " + nama + " (" + nim + ")");
                JOptionPane.showMessageDialog(this, "Data mahasiswa berhasil disimpan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == tombolReset) {
            fieldNIM.setText("");
            fieldNama.setText("");
            labelHasil.setText("Silakan isi formulir terlebih dahulu.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}