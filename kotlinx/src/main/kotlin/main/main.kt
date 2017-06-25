package main
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

// Coroutine ARE light weight 
fun are_light_weight() = runBlocking<Unit>{
  println("called ARE light weight")
  val jobs = List(100_000) { // create a lot of coroutines and list their jobs
    launch(CommonPool) {
      delay(1000L)
      print(".")
    }
  }
  jobs.forEach { it.join() } // wait for all jobs to complete
}

//Coroutine like Daemon thread
fun daemon() = runBlocking<Unit> {
  launch(CommonPool) {
    repeat(1000) { i ->
      println("I'm sleeping $i ...")
      delay(500L)
    }
  }
  delay(13000L) // just quit after delay
}

// Channel Basic
fun channel() = runBlocking<Unit> {
  val channel = Channel<Int>()
  launch(CommonPool) {
    // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
    for (x in 1..5) channel.send(x * x)
  }
  // here we print five received integers:
  repeat(5) { println(channel.receive()) }
  println("Done!")
}

fun channel_iter() = runBlocking<Unit> {
  println("channel iter")
  val channel = Channel<Int>()
  launch(CommonPool) {
    for (x in 1..5) channel.send(x * x)
    channel.close() // we're done sending
  }
  // here we print received values using `for` loop (until the channel is closed)
  for (y in channel) println(y)
  println("Done!")
}

fun main( args : Array<String> ) { 
  val arg = args.toList()
  when {
    arg.contains("ARE")      -> are_light_weight()
    arg.contains("daemon")   -> daemon()
    arg.contains("channel")  -> channel()
    arg.contains("channel_iter") -> channel_iter()
  }
}
