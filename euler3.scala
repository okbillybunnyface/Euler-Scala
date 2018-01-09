object Main
{
	def main(args:Array[String])
	{
		println("Enter a number.")
		val num = scala.io.StdIn.readLong()
		println(primeFactors(num).max)
	}

	def primeFactors(num:Long):Array[Long] =
	{
		def getPrimes(max:Long) = 
		{
			def eratosthenes(r:Array[Long], routeMax:Double, depth:Int = 0):Array[Long] = 
			{
				if(r(0) > routeMax) return new Array[Long](depth)++r
				val ret = eratosthenes(r.filter((x)=>x%r(0)!=0), routeMax, depth+1)
				ret(depth) = r(0)
				ret
			}
			eratosthenes((2L to max).toArray[Long], Math.pow(max, 0.5))
		}

		def lowestFactor(num:Long,candidates:Array[Long]):Long = 
		if(num%candidates(0)==0) candidates(0) 
		else lowestFactor(num,candidates.tail)

		def primeFactorsRecursive(num:Long, primes:Array[Long], depth:Int):Array[Long] =
		{
			val factor = lowestFactor(num,primes)
			if(num==factor) (new Array[Long](depth)):+num
			else
			{
				val ret = primeFactorsRecursive(num/factor,primes,depth+1)
				ret(depth) = factor
				ret
			}
		}
		primeFactorsRecursive(num, getPrimes(Math.ceil(Math.pow(num,0.5)).toLong), 0)
	}
}