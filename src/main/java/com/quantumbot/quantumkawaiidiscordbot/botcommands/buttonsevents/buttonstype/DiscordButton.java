package com.quantumbot.quantumkawaiidiscordbot.botcommands.buttonsevents.buttonstype;

public enum DiscordButton {
    PREV("prev","Prev"),
    NEXT("next","Next");
    private String buttonId;
    private String buttonLabel;

    DiscordButton(String buttonId, String buttonLabel) {
        this.buttonId = buttonId;
        this.buttonLabel = buttonLabel;
    }

    public String getButtonId() {
        return buttonId;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }
}
