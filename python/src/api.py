from fastapi import FastAPI
from pydantic import BaseModel
import os

# Define the request body model for the API
class ChatRequest(BaseModel):
    message: str

# Create the FastAPI application instance
app = FastAPI()

@app.post("/predict")
def predict(request: ChatRequest):
    """
    This endpoint receives a user's message and returns a placeholder
    machine learning model response.
    """
    print(f"Received message for prediction: '{request.message}'")

    # In the future, this is where the call to the ML model would go.
    # For now, we'll return a simple, hardcoded response.
    reply = f"This is a placeholder ML response to the message: '{request.message}'"

    return {"reply": reply}

@app.get("/")
def read_root():
    """
    Root endpoint to check if the API is running.
    """
    return {"message": "ML Chatbot API is running."}
