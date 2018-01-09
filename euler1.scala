object Main
{
	def main(args: Array[String])
	{
		println("Enter number.")
		val max = scala.io.StdIn.readInt()
		val mul3 = multiples(3, max)
		val mul5 = multiples(5, max)
		val sum = mul3.diff(mul5).reduce((x,y)=>x+y) + mul5.reduce((x,y)=>x+y)
		println(sum)
	}

	def multiples(num: Int, top: Int): Array[Int] = multiples(num, top, num, 0)

	def multiples(num: Int, top: Int, iter: Int, depth: Int): Array[Int] = 
	{
		if(num < top) Array(num)++multiples(num + iter, top, iter, depth + 1)
		else new Array[Int](0)
	}
}