variable "ACCESS_KEY" {}
variable "SECRET_KEY" {}
variable "ORG_ID" {}

provider "scaleway" {
  access_key      = var.ACCESS_KEY
  secret_key      = var.SECRET_KEY
  organization_id = var.ORG_ID
  zone            = "fr-par-1"
  region          = "fr-par"
}

resource "scaleway_instance_ip" "public_ip" {}

resource "scaleway_instance_server" "my-ubuntu-instance" {
  type  = "DEV1-S"
  image = "ubuntu-focal"
  ip_id = scaleway_instance_ip.public_ip.id
}