document.addEventListener("DOMContentLoaded", () => {
    const chatMessages = document.getElementById("chat-messages");
    const userInput = document.getElementById("user-input");
    const sendButton = document.getElementById("send-button");

    const addMessage = (text, sender) => {
        const messageElement = document.createElement("div");
        messageElement.classList.add("message", sender);
        const textElement = document.createElement("div");
        textElement.classList.add("text");
        textElement.innerText = text;
        messageElement.appendChild(textElement);
        chatMessages.appendChild(messageElement);
        chatMessages.scrollTop = chatMessages.scrollHeight;
    };

    const sendMessage = async () => {
        const message = userInput.value.trim();
        if (message) {
            addMessage(message, "user");
            userInput.value = "";

            try {
                const response = await fetch("/api/v1/chat", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ message: message }),
                });

                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }

                const data = await response.json();
                addMessage(data.reply, "bot");
            } catch (error) {
                console.error("Error sending message:", error);
                addMessage("Sorry, something went wrong. Please try again.", "bot");
            }
        }
    };

    sendButton.addEventListener("click", sendMessage);

    userInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            sendMessage();
        }
    });
});
