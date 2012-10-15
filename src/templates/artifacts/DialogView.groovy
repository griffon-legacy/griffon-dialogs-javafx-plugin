@artifact.package@content = scene(id: 'content', fill: BLACK) {
    hbox(padding: 80) {
        text(text: "Dialog", font: "80pt sanserif") {
            fill linearGradient(endX: 0, stops: [[0, ORANGE], [1, CHOCOLATE]])
        }
        text(text: "FX", font: "80pt sanserif") {
            fill linearGradient(endX: 0, stops: [[0, CYAN], [1, DODGERBLUE]])
            effect dropShadow(color: DODGERBLUE, radius: 25, spread: 0.25)
        }
    }
}
