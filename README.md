# MusicPlayerProject

Welcome to the **Music Player Project**! This is a simple Java-based music player that can be run from the terminal using **Gradle**. Below you'll find the steps to set it up and run it on your local machine.

## Prerequisites

Make sure you have the following installed:
- **Java**: You need to have Java 8 or higher installed. [Download Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Gradle**: Gradle is used for building and running the project. You can install it via [Gradle Installation Guide](https://gradle.org/install/).

If you're using **Git Bash** or any terminal that supports bash commands, you're good to go!

## Getting Started

### 1. Clone the Repository
Clone the repository to your local machine:

```bash
git clone https://github.com/alh303/Group14-gp23-.git
Change to the project directory:


cd Group14-gp23-
2. Build the Project
Once you have the project on your local machine, you'll need to build it using Gradle. From the terminal, run the following command:


./gradlew build
This will download any required dependencies and compile the project.

3. Run the Music Player
To run the music player, use the following command in the terminal. You'll need to provide the path to the audio file you wish to play. Make sure the audio file is in a supported format (e.g., .wav, .mp3).

For example:


./gradlew run --args='"C:/Users/lecre/MusicPlayerProject/app/music/Marvin Gaye - Whats Going On.wav"'
This command will start the music player and begin playing the specified file.

Note: Replace "C:/Users/lecre/MusicPlayerProject/app/music/Marvin Gaye - Whats Going On.wav" with the path to your own audio file if you want to play a different song.

4. Interactive Commands (Optional)
If your music player has interactive features like play, pause, stop, etc., you can enter those commands after running the player. For example, if your program supports commands like "pause" or "stop", it might look like this:


$ ./gradlew run --args="play /path/to/music/file.wav"
Then you can interact with it using the terminal.

Troubleshooting
Issue with Dependencies: If you run into issues building the project due to missing dependencies, try running:


./gradlew clean build
Invalid Audio Path: Ensure that the file path to the audio file is correct. If you receive a "file not found" error, check that the path is valid.

License
This project is licensed under the MIT License - see the LICENSE file for details.



