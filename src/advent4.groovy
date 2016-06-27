import java.security.*;

md = MessageDigest.getInstance("MD5");

def test1 = { b -> (b[0] == 0) && (b[1] == 0) && (b[2] == (b[2] & 0x0f)) }

def test2 = { b -> (b[0] == 0) && (b[1] == 0) && (b[2] == 0) }

def check = { secret, test ->
    for (it in 1..10_000_000) {
        md = MessageDigest.getInstance("MD5");
        md.update("${secret}${it}".bytes);
        checksum = md.digest().collect {(int) it & 0xff}
        if ( test(checksum) ) {
            // println "found match! ${it}"
            return it;
        }
    }
}

// Sample input:
// assert part1("abcdef") == 609043

println "Part 1: " + check("bgvyzdsv", test1)
println "Part 2: " + check("bgvyzdsv", test2)
