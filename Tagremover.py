import os

def clean_mp3_filenames():
    directory = os.getcwd()  # Get the current working directory
    for filename in os.listdir(directory):
        if filename.endswith(".mp3") and "SpotiDown.App - " in filename:
            new_name = filename.replace("SpotiDown.App - ", "")
            old_path = os.path.join(directory, filename)
            new_path = os.path.join(directory, new_name)
            
            # Check if the new file name already exists and append a number if needed
            counter = 1
            while os.path.exists(new_path):
                name, ext = os.path.splitext(new_name)
                new_name = f"{name} ({counter}){ext}"
                new_path = os.path.join(directory, new_name)
                counter += 1
            
            os.rename(old_path, new_path)
            print(f'Renamed: "{filename}" -> "{new_name}"')

if __name__ == "__main__":
    clean_mp3_filenames()
    print("Renaming complete.")