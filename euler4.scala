object Main
{
	def main(args:Array[String])
	{
		val factors = (100 to 999).toArray[Int].reverse
		println(findPalindromeNumber(factors))
	}

	def findPalindromeNumber(factors:Array[Int]):Int=
	{
		def countDown(num:Int, factors:Array[Int]):Int=
		{
			if(factors.length == 0) return 0
			if(intIsPalindrome(num*factors(0))) num*factors(0)
			else countDown(num, factors.tail)
		}
		val candidate = countDown(factors(0),factors)
		if(candidate != 0) candidate
		else findPalindromeNumber(factors.tail)
	}

	def intIsPalindrome(num:Int):Boolean=
	{
		val str = num.toString
		val rev = str.split("").reverse.reduce((x,y)=>x+y)
		(str==rev)
	}
}