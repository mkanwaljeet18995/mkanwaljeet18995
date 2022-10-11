import speech_recognition
import pyaudio
import pyttsx3

# python Speech_Recognition.py
recogniser = speech_recognition.Recognizer()
while True:
    try:
        with speech_recognition.Microphone() as mic:
            recogniser.adjust_for_ambient_noise(mic, duration=0.2)
            audio = recogniser.listen(mic)
            text = recogniser.recognize_google(audio)
            text = text.lower()
            print(f"> {text}")
    except speech_recognition.UnknownValueError():
        recogniser = speech_recognition.Recognizer()
        continue
