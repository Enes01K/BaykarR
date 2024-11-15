@test
Feature:Baykar Test Case
  Scenario:Baykar Ekrani Navbar Kontrolu
    Given Baykar anasayfasi acilir
    Then Navbar elementlerin tiklanabilirliginin kontrolu yapilir
    Then navbardaki tum elementlere tiklandi ve siteden ayrildik
  Scenario:Baykar Ekrani Dil Kontrolu
    Given Baykar kariyer sayfasi acilir
    Then Navbar elementlerinin türkçe halleri kayıt edilir ve ingilizceleriyle karsilastirilir
