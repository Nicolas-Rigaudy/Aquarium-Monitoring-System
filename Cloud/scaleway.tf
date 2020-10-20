variable "TF_VAR_ACCESS_KEY" {}
variable "TF_VAR_SECRET_KEY" {}
variable "TF_VAR_ORG_ID" {}

provider "scaleway" {
  access_key      = var.TF_VAR_ACCESS_KEY
  secret_key      = var.TF_VAR_SECRET_KEY
  organization_id = var.TF_VAR_ORG_ID
  zone            = "fr-par-1"
  region          = "fr-par"
}

resource "scaleway_instance_ip" "public_ip" {}

resource "scaleway_instance_server" "my-ubuntu-instance" {
  type  = "DEV1-S"

  ip_id = scaleway_instance_ip.public_ip.id
}