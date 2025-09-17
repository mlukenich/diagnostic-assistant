import pandas as pd
import joblib
import argparse
import os
from model import build_model

def load_data(data_path):
    """
    Loads data from a CSV file.

    NOTE: This is a placeholder. We will implement this later.
    """
    print(f"Placeholder: Loading data from {data_path}...")
    # In the future, this will be something like:
    # df = pd.read_csv(data_path)
    # X = df.drop('target_column', axis=1)
    # y = df['target_column']
    # return X, y
    return None, None

def train_model(model, X, y):
    """
    Trains the model.

    NOTE: This is a placeholder. We will implement this later.
    """
    print("Placeholder: Training model...")
    if X is not None and y is not None:
        # In the future, this will be:
        # model.fit(X, y)
        print("Model training would happen here.")
    else:
        print("Cannot train model without data.")
    return model

def save_model(model, model_path):
    """
    Saves the trained model to a file.
    """
    # Ensure the directory exists
    os.makedirs(os.path.dirname(model_path), exist_ok=True)
    print(f"Saving model to {model_path}...")
    joblib.dump(model, model_path)
    print("Model saved successfully.")

def main(data_path, model_path):
    """
    Main function to orchestrate the model training process.
    """
    print("--- Starting Training Pipeline ---")

    # Get the directory of the current script
    script_dir = os.path.dirname(os.path.abspath(__file__))

    # Construct absolute paths
    if not os.path.isabs(data_path):
        data_path = os.path.join(script_dir, data_path)
    if not os.path.isabs(model_path):
        model_path = os.path.join(script_dir, model_path)

    # Load data
    X, y = load_data(data_path)

    # Build model
    model = build_model()
    print("Model built.")

    # Train model
    trained_model = train_model(model, X, y)

    # Save model
    if trained_model is not None:
        # For now, we save the untrained model to have the file structure ready
        save_model(trained_model, model_path)

    print("--- Training Pipeline Finished ---")

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description="Training script for the model.")
    parser.add_argument('--data_path', type=str, default='../data/gastrointestinal_disease_dataset.csv', help='Path to the training data.')
    parser.add_argument('--model_path', type=str, default='../models/model.joblib', help='Path to save the trained model.')

    args = parser.parse_args()

    main(args.data_path, args.model_path)
