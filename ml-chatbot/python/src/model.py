from sklearn.ensemble import RandomForestClassifier

def build_model():
    """
    Builds and returns a Random Forest Classifier model.
    """
    # We can tune the hyperparameters later
    model = RandomForestClassifier(n_estimators=100, random_state=42)
    return model

if __name__ == '__main__':
    # This part is for testing the model build process
    model = build_model()
    print("Model built successfully:")
    print(model)
