package org.example;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App {
    private static Clip clip;
    private static File audioFile;

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a valid audio file path.");
            return;
        }

        audioFile = new File(args[0]);
        if (!audioFile.exists()) {
            System.out.println("Audio file not found: " + audioFile.getAbsolutePath());
            return;
        }

        SwingUtilities.invokeLater(App::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton playButton = new JButton("Play");
        JButton pauseButton = new JButton("Pause");
        JButton stopButton = new JButton("Stop");
        JButton exitButton = new JButton("Exit");

        playButton.addActionListener(e -> play());
        pauseButton.addActionListener(e -> pause());
        stopButton.addActionListener(e -> stop());
        exitButton.addActionListener(e -> exit(frame));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(stopButton);
        panel.add(exitButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        loadAudio();
    }

    private static void loadAudio() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, "Error loading audio: " + e.getMessage());
        }
    }

    private static void play() {
        if (clip != null) {
            if (!clip.isRunning()) {
                clip.start();
                JOptionPane.showMessageDialog(null, "Now playing: " + audioFile.getName());

                // Save to MongoDB
                DatabaseManager.saveSongPlay(audioFile.getName());
            }
        }
    }

    private static void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            JOptionPane.showMessageDialog(null, "Paused");
        }
    }

    private static void stop() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            JOptionPane.showMessageDialog(null, "Stopped and reset");
        }
    }

    private static void exit(JFrame frame) {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
        frame.dispose();
    }
}
