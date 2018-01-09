object Main
{
	def main(args: Array[String])
	{
		println("Enter number.")
		val max = scala.io.StdIn.readInt()
		val sumEven = fibonnaci(max).filter((x)=>x%2==0).reduce((x,y)=>x+y)
		println(sumEven)
	}

	def fibonnaci(max: Int): Array[Int] = fibonnaci(max, 1, 1, 0)

	def fibonnaci(max: Int, a: Int, b: Int, depth: Int): Array[Int] = 
	{
		val ret = 
		if(a+b <= max) fibonnaci(max, b, a+b, depth+1)
		else 
		{
			val ret = new Array[Int](depth + 2)
			ret(depth + 1) = b
			ret
		}
		ret(depth) = a
		ret
	}
}