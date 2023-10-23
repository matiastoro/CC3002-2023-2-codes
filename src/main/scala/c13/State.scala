package c13

object State {

  class Safe {
    private var state: State = new Open()
    def setState(state: State) = this.state = state

    def open() = state.open(this)
    def close() = state.close(this)
    def enterCode() = state.enterCode(this)
    def lock() = state.lock(this)
  }

  trait State {
    def error() = throw new Error("ups!")
    def open(safe: Safe): Unit = error()
    def close(safe: Safe): Unit = error()
    def enterCode(safe: Safe): Unit = error()
    def lock(safe: Safe): Unit = error()
  }

  class Open extends State {
    override def close(safe: Safe) = safe.setState(new Closed())
  }

  class Closed extends State {
    override def open(safe: Safe) = safe.setState(new Open())
    override def lock(safe: Safe) = safe.setState(new Locked())
  }

  class Locked extends State {
    override def enterCode(safe: Safe) = safe.setState(new Closed())
  }

}
