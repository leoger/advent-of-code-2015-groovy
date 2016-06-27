input = new File("day5.txt").text.tokenize()

assert ("abba" =~ /ab|cd|pq|xy/)
assert ("aaa" =~ /([aeiou].*){3}/)
assert ("ababba" =~ /(.)\1/)

l1 = input.findAll { ! (it =~ /ab|cd|pq|xy/)} findAll { it =~ /([aeiou].*){3}/ } findAll { it =~ /(.)\1/ }
println l1.size()

assert ("abaxqwxab" =~ /(..).*\1/)

l2 = input.findAll { it =~ /(..).*\1/ } findAll { it =~ /(.).\1/ }
println l2.size()